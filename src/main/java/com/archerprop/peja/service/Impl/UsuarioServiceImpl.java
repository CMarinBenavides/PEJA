package com.archerprop.peja.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.Query;
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
import org.springframework.transaction.annotation.Transactional;
import com.archerprop.peja.service.UsuarioService;

import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RoleRepositorio RoleRepositorio;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO, String userRol) {
        if (usuarioRepositorio.existsByCorreo(registroDTO.getCorreo())) {
            return null;
        }
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

    @Override
    public List<Usuario> listarUsuariosAdmin() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<Usuario> usuariosAdmin = usuarios.stream()
                .filter(usuario -> usuario.getRoles().stream().anyMatch(rol -> rol.getName().equals("ADMIN")))
                .collect(Collectors.toList());
        return usuariosAdmin;
    }

    @Override
    @Transactional
    public boolean eliminar(Usuario registroDTO) {
        try {
            String sql = "DELETE FROM public.usuarios_roles WHERE usuario_id=" + registroDTO.getId();
            Query query = entityManager.createNativeQuery(sql);
            query.executeUpdate();
            String sql1 = "DELETE FROM public.usuarios WHERE id=" + registroDTO.getId();
            Query query1 = entityManager.createNativeQuery(sql1);
            query1.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificar(UsuarioRegistroDTO registroDTO, String userRol) {
        Usuario usuarioR = usuarioRepositorio.findByCorreo(registroDTO.getCorreo());
        try {
            Rol rol = RoleRepositorio.findByName(userRol);
            Collection<Rol> roles = Arrays.asList(rol);
            Usuario usuario = new Usuario(
                    usuarioR.getId(),
                    registroDTO.getCedula(),
                    registroDTO.getNombre(),
                    registroDTO.getApellido(),
                    registroDTO.getCorreo(),
                    new BCryptPasswordEncoder().encode(registroDTO.getClave()),
                    roles);
            usuarioRepositorio.save(usuario);
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar el usuario: " + e.getMessage());
            return false;
        }
    }

}
