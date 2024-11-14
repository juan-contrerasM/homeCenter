package com.home.proyectoFinalHomeC;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "proveedores")
public class Provedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cedula;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "rut")
    private String rut;
    @Column(name = "descuento")
    private float descuento;
}
