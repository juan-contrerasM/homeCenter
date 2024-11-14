package com.home.proyectoFinalHomeC.entity;

import com.home.proyectoFinalHomeC.entity.normalizacion.Venta_producto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    @Column(nullable = false, length = 200)
    private String descripcion;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    private float total;
    @Column(nullable = false)
    private int cantidad_producto;
    @Column(nullable = false)
    private Long impuesto;


    @ManyToOne
    @JoinColumn(name ="cedula_cliente" )
    private Cliente cliente;


    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<Venta_producto>listaVentaProdcuto;
}
