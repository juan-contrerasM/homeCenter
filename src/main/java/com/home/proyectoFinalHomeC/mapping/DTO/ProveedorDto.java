package com.home.proyectoFinalHomeC.mapping.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProveedorDto {

    @NotBlank(message = "este campo no puede estar vacio")
    private String cedula;
    @NotBlank(message = "este campo no puede estar vacio")
    private String nombre;
    @NotBlank(message = "este campo no puede estar vacio")
    private String rut;
    @NotNull(message = "este campo no puede ser nulo")
    private float descuento;
}
