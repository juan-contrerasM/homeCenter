package com.home.proyectoFinalHomeC.entity.normalizacion;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tipo_telefono")
public class Tipo_telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_telefono;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipo_telefono",cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<Telefono_cliente> telefonoClientesList;

}
