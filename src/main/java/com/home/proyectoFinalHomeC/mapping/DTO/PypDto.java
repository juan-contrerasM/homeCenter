package com.home.proyectoFinalHomeC.mapping.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class PypDto {

    @NotBlank(message = "Esta campo no puede estar")
    private String cedula;
    @NotBlank(message = "Esta campo no puede estar")
    private String nombre;
    @NotNull(message = "Esta campo no puede estar")
    private int cantida_recuperaciones;
    @NotBlank(message = "Esta campo no puede estar")
    private String pypcol;
}
