package com.home.proyectoFinalHomeC.entity;

import com.home.proyectoFinalHomeC.entity.normalizacion.Area;
import com.home.proyectoFinalHomeC.entity.normalizacion.Tipo_producto;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "precio",nullable = false)
    private Double precio;
    @Column(name = "cantidad",nullable = false)
    private Integer cantidad;



    @ManyToOne
    @JoinColumn(name = "id_tipo_producto")
    private Tipo_producto tipo_producto;

    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area area;
}
