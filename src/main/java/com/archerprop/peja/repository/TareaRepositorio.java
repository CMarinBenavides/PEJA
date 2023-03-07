package com.archerprop.peja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.archerprop.peja.entity.Tareas;

public interface TareaRepositorio extends JpaRepository<Tareas, Long> {

    public abstract List<Tareas> findByNombre(String nombre);

    public abstract List<Tareas> findByEstudiante(String estudiante);

    public abstract List<Tareas> findByCurso(String curso);

    public abstract List<Tareas> findByDocente(String docente);

    public abstract List<Tareas> findByNombreAndDocente(String nombre, String docente);

}
