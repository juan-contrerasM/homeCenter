package com.home.proyectoFinalHomeC.entity;

import com.home.proyectoFinalHomeC.entity.normalizacion.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


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

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    private List<Venta_producto> listaVentaProducto;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Rotura> listaRoturas;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<NotaProductoPedido> listaVentaProdcuto;



    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoProveedor> listaProductoProveedor;


}
