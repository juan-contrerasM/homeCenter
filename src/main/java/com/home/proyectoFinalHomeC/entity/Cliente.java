package com.home.proyectoFinalHomeC.entity;

import com.home.proyectoFinalHomeC.entity.normalizacion.Direccion;
import com.home.proyectoFinalHomeC.entity.normalizacion.Telefono_cliente;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(nullable = false)
    private Long cedula_cliente;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String primer_apellido;

    @Column(nullable = false)
    private String segundo_apellido;

    @ManyToOne
    @JoinColumn(name="id_direccion", nullable = false)
    private Direccion direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<Telefono_cliente>listaTelefonoCliente;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<Venta> listaVentas;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<NotaPedido>listaNostasPedido;

}
