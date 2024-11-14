package com.home.proyectoFinalHomeC.entity.normalizacion;

import com.home.proyectoFinalHomeC.entity.NotaPedido;
import com.home.proyectoFinalHomeC.entity.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notas_productos_pedidos")
@Data
public class NotaProductoPedido {
    private int cantidad;
    @EmbeddedId
   private  NotaProductoPedidoID notaProductoPedidoID;


    @MapsId("consecutivo")
    @ManyToOne
    @JoinColumn(name = "consecutivo", insertable = false, updatable = false)
    private NotaPedido notaPedido;



    @MapsId("id_producto")
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;
}
