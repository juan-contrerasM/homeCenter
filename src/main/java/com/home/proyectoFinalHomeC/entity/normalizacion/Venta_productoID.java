package com.home.proyectoFinalHomeC.entity.normalizacion;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Venta_productoID {

    private Long id_venta;
    private Long id_producto;

    // Constructor, getters, setters, equals() y hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta_productoID that = (Venta_productoID) o;
        return id_producto.equals(that.id_producto) && id_venta.equals(that.id_venta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_producto, id_venta);
    }
}
