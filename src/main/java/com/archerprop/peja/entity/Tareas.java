package com.archerprop.peja.entity;

import java.sql.Date;
import java.sql.Time;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo_tarea", nullable = false)
    private String titulo;

    @Column(name = "descripcion_tarea", nullable = false)
    private String descripcion;

    @Column(name = "docente_tarea", nullable = false)
    private Long docente;

    @Column(name = "fecha_entrega_tarea", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;

    @Column(name = "hora_entrega_tarea", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private Time horaEntrega;

    public void finalize() throws Throwable {

    }

}
