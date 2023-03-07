package com.archerprop.peja.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.archerprop.peja.dto.UsuarioRegistroDTO;
import com.archerprop.peja.entity.Usuario;

public interface UsuarioService extends UserDetailsService {

    public Usuario guardar(UsuarioRegistroDTO usuarioDTO, String rol);

    public Usuario buscarUsuario(String correo);

    public List<Usuario> listarUsuariosAdmin();

    public boolean eliminar(Usuario usuarioDTO);

    public boolean modificar(UsuarioRegistroDTO usuarioDTO, String rol);

}
