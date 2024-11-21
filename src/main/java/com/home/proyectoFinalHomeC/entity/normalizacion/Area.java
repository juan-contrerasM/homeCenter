package com.home.proyectoFinalHomeC.entity.normalizacion;

import com.home.proyectoFinalHomeC.entity.Producto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "areas")
public class Area {
    @Id
    @Column(name = "id_area", nullable = false)
    private Long id_area;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

   // @OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
    //private List<Producto> listaProductos;

}
