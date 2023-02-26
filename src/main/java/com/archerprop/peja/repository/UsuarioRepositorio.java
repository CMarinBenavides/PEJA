package com.archerprop.peja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archerprop.peja.entity.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByCorreo(String correo);

}
