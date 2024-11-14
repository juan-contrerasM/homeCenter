package com.home.proyectoFinalHomeC.entity.normalizacion;

import com.home.proyectoFinalHomeC.entity.Cliente;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "telefono_clientes")
public class Telefono_cliente {

    @EmbeddedId
    private TelefonoClienteId id;  // Clave primaria compuesta


    @ManyToOne
    @MapsId("cedula_cliente") // Mapea el campo "cedulaCliente" en TelefonoClienteId
    @JoinColumn(name = "cedula_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @MapsId("tipo_telefono") // Mapea el campo "tipoTelefono" en TelefonoClienteId
    @JoinColumn(name = "tipo_telefono", insertable = false, updatable = false)
    private Tipo_telefono tipo_telefono;

    @Column(nullable = false)
    private String numero;

}
