package com.archerprop.peja.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archerprop.peja.entity.Usuarios;

public interface UsuarioRepositorio extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByCorreo(String correo);

    public abstract List<Usuarios> findByNombre(String nombre);

    public abstract List<Usuarios> findByApellido(String apellido);

    public abstract List<Usuarios> findByNombreAndApellido(String nombre, String apellido);

    public abstract List<Usuarios> findByNombreOrApellido(String nombre, String apellido);

}
