package com.home.proyectoFinalHomeC.entity;

import com.home.proyectoFinalHomeC.entity.normalizacion.Estado;
import com.home.proyectoFinalHomeC.entity.normalizacion.NotaProductoPedido;
import com.home.proyectoFinalHomeC.entity.normalizacion.Venta_producto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name ="notas_pedidos")
public class NotaPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  consecutivo;
    @Column(nullable = false)
    private LocalDate fehaEntrega;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private String novedad;


    @ManyToOne
    @JoinColumn(name= "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name= "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name= "id_pyp")
    private Pyp pyp;


    @ManyToOne
    @JoinColumn(name = "cedula")
    private Operador operador;

    @OneToMany(mappedBy = "notaPedido", cascade = CascadeType.ALL)
    private List<NotaProductoPedido> listaVentaProdcuto;

}
