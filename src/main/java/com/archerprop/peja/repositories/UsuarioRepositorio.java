package com.archerprop.peja.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.archerprop.peja.entity.Usuarios;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuarios, Long> {

    public abstract Usuarios findByCorreo(String correo);

    public abstract List<Usuarios> findByNombre(String nombre);

    public abstract List<Usuarios> findByApellido(String apellido);

    public abstract List<Usuarios> findByNombreAndApellido(String nombre, String apellido);

    public abstract List<Usuarios> findByNombreOrApellido(String nombre, String apellido);

}
