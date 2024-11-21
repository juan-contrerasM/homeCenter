package com.home.proyectoFinalHomeC.mapping.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;
@Data
public class AreaDto {

    private Long id_area;
    @NotBlank(message = "este campo no puede estar vacio")
    private String nombre;
    @NotBlank(message = "este campo no puede estar vacio")
    private String descripcion;
}
