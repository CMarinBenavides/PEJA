package com.archerprop.peja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRegistroDTO {

    private Long id;

    private Long cedula;

    private String nombre;

    private String apellido;

    private String correo;

    private String clave;

    public UsuarioRegistroDTO(Long cedula, String nombre, String apellido, String correo, String clave) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }
}
