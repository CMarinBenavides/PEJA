package com.archerprop.peja.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.archerprop.peja.dto.UsuarioRegistroDTO;
import com.archerprop.peja.entity.Rol;
import com.archerprop.peja.entity.Usuario;
import com.archerprop.peja.repository.RoleRepositorio;
import com.archerprop.peja.repository.UsuarioRepositorio;

import com.archerprop.peja.service.UsuarioService;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RoleRepositorio RoleRepositorio;

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO, String userRol) {
        Rol rol = RoleRepositorio.findByName(userRol);
        Collection<Rol> roles = Arrays.asList(rol);
        Usuario usuario = new Usuario(
                registroDTO.getCedula(),
                registroDTO.getNombre(),
                registroDTO.getApellido(),
                registroDTO.getCorreo(),
                new BCryptPasswordEncoder().encode(registroDTO.getClave()),
                roles);
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByCorreo(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new User(usuario.getCorreo(), usuario.getClave(), getAuthorities(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public Usuario buscarUsuario(String correo) {
        return usuarioRepositorio.findByCorreo(correo);
    }

}
