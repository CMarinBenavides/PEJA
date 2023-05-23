package com.archerprop.peja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archerprop.peja.entity.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByCorreo(String correo);

    Usuario findByCedula(Long cedula);

    Boolean existsByCorreo(String correo);

    Boolean existsByCedula(Long cedula);
}
