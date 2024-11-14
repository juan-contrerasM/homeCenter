package com.home.proyectoFinalHomeC.entity.normalizacion;

import com.home.proyectoFinalHomeC.entity.NotaPedido;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado;
    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<NotaPedido> listaNotapedido;
}
