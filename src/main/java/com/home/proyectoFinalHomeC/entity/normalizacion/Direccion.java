package com.home.proyectoFinalHomeC.entity.normalizacion;

import com.home.proyectoFinalHomeC.entity.Cliente;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id_direccion;

    @Column(nullable = false, length = 30)
    private String calle;

    @Column(nullable = false, length = 30)
    private String carrera;

    @Column(nullable = false, length = 30)
    private String numero;

    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL)
    private List<Cliente>listaClientes;

}
