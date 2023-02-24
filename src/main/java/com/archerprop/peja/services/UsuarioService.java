package com.archerprop.peja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import com.archerprop.peja.entity.Usuarios;
import com.archerprop.peja.repositories.UsuarioRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Log4j2
public class UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public boolean autenticar(Usuarios usuario) {
        if (usuario == null) {
            return false;
        }
        if (usuario.getCorreo() == null || usuario.getClave() == null) {
            return false;
        }
        // try {
        // Usuarios usuarioEncontrado =
        // usuarioRepositorio.findByCorreo(usuario.getCorreo());
        // if (usuarioEncontrado.getClave().equals(usuario.getClave())) {
        // return true;
        // } else {
        // return false;
        // }
        // } catch (Exception e) {
        // log.error("Error al autenticar el usuario: " + e.getMessage());
        // return false;
        // }
        return true;
    }

    public Usuarios obtenerUsuario(String correo) {
        // try {
        // Usuarios usuario = usuarioRepositorio.findByCorreo(correo);
        // return usuario;
        // } catch (Exception e) {

        // log.error("Error al obtener el usuario: " + e.getMessage());
        // return null;
        // }
        return null;
    }

    public Object getAll() {
        try {
            List<Usuarios> usuarios = usuarioRepositorio.findAll();
            return usuarios;
        } catch (Exception e) {
            log.error("Error al obtener los usuarios: " + e.getMessage());
            return null;
        }
    }

}
