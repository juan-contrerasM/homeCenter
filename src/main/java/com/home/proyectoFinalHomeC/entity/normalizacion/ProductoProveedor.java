package com.home.proyectoFinalHomeC.entity.normalizacion;

import com.home.proyectoFinalHomeC.Provedor;
import com.home.proyectoFinalHomeC.entity.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class ProductoProveedor {

    @EmbeddedId
    private ProductoProveeorID productoProveeorID;

    @MapsId("cedula")
    @ManyToOne
    @JoinColumn(name = "cedula", insertable = false, updatable = false)
    private Provedor proveedor;
    @MapsId("id_producto")
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;


    @Column(nullable = false)
    private  int cantidad;
    @Column(nullable = false)
    private float costo;
}
