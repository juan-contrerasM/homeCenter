package com.home.proyectoFinalHomeC.entity.normalizacion;

import com.home.proyectoFinalHomeC.entity.Producto;
import com.home.proyectoFinalHomeC.entity.Venta;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ventas_productos")
public class Venta_producto {

    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private float valor;

    @EmbeddedId
    private Venta_productoID ventaProductoID;

    @MapsId("id_venta")
    @ManyToOne
    @JoinColumn(name = "id_venta", insertable = false, updatable = false)
    private Venta venta;

    @MapsId("id_producto")
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;
}
