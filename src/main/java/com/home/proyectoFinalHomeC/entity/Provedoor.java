package com.home.proyectoFinalHomeC.entity;

import com.home.proyectoFinalHomeC.entity.normalizacion.NotaProductoPedido;
import com.home.proyectoFinalHomeC.entity.normalizacion.ProductoProveedor;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "proveedores")
@Data
public class Provedoor {

    @Id
    @Column(nullable = false)
    private String cedula;
    private String nombre;
    private String rut;
    private float descuernto;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<ProductoProveedor> listaProductoProveedor;


}
