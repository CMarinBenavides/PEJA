package com.archerprop.peja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.archerprop.peja.entity.Tareas;

public interface TareaRepositorio extends JpaRepository<Tareas, Long> {

    public List<Tareas> findByDocente(Long docente);

    public Tareas findById(long id);

    public Tareas findByTitulo(String titulo);

    public boolean existsByTitulo(String titulo);

}
