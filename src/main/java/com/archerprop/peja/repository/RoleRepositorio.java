package com.archerprop.peja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archerprop.peja.entity.Rol;

public interface RoleRepositorio extends JpaRepository<Rol, Long> {

    Rol findByName(String name);

}
