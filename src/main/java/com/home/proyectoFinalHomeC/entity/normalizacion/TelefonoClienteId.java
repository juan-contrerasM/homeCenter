package com.home.proyectoFinalHomeC.entity.normalizacion;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TelefonoClienteId implements Serializable {

    private Long cedula_cliente;
    private Long tipo_telefono;

    // Constructor, getters, setters, equals() y hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonoClienteId that = (TelefonoClienteId) o;
        return cedula_cliente.equals(that.cedula_cliente) && tipo_telefono.equals(that.tipo_telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula_cliente, tipo_telefono);
    }
}