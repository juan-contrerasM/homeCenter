package com.home.proyectoFinalHomeC.entity.normalizacion;




import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class NotaProductoPedidoID implements Serializable {

    private Long consecutivo;
    private Long  id_producto;

    // Constructor, getters, setters, equals() y hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaProductoPedidoID that = (NotaProductoPedidoID) o;
        return id_producto.equals(that.id_producto) && consecutivo.equals(that.consecutivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consecutivo, id_producto);
    }
}
