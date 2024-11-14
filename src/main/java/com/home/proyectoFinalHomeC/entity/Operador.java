package com.home.proyectoFinalHomeC.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "operadores")
public class Operador {

    @Id
    private String cedula;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private LocalDate fecha_nacimiento;
    @Column(nullable = false)
    private String indicador_aislamiento;

    @OneToMany(mappedBy = "operador", cascade = CascadeType.ALL)
    private List<NotaPedido> nostasPedidos;
}
