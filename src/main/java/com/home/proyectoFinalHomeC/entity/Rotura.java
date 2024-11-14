package com.home.proyectoFinalHomeC.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "rotura")
public class Rotura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id_rotura;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private LocalDate fecha;


    @ManyToOne
    @JoinColumn(name = "id_producto")
    private  Producto producto;
}
