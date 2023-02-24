package com.archerprop.peja.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tareas implements Serializable {
    @Id
    private Long id;

    private String nombre;
    private String descripcion;
    private String fecha;
    private String hora;
    private String curso;
    private String docente;
    private String estado;
    private String fechaEntrega;
    private String horaEntrega;
    private String nota;
    private String observacion;
    private String estudiante;
    private String archivoEntregado;
    private String tipoEntregado;

}
