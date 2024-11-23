package com.home.proyectoFinalHomeC.mapping.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.home.proyectoFinalHomeC.entity.NotaPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
public class OperadorDto {


    @NotBlank(message = "este campo no puede estar vacio")
    private String cedula;
    @NotBlank(message = "este campo no puede estar vacio")
    private String nombre;
    @NotBlank(message = "este campo no puede estar vacio")
    private String apellido;

    @NotNull(message = "este campo no puede estar vacio")
    private String indicador_aislamiento;

}
