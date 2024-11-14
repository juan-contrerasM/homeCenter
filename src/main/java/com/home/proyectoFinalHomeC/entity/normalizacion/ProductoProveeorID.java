package com.home.proyectoFinalHomeC.entity.normalizacion;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class ProductoProveeorID {



        private Long cedula;
        private Long  id_producto;

        // Constructor, getters, setters, equals() y hashCode()

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductoProveeorID that = (ProductoProveeorID) o;
            return id_producto.equals(that.id_producto) && cedula.equals(that.cedula);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cedula, id_producto);
        }


}
