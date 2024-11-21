package com.home.proyectoFinalHomeC.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "pyps")
public class Pyp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pyp ;
    @Column(nullable = false)
    private String cedula;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int cantida_recuperaciones;
    @Column(nullable = false)
    private String pypcol;



}
