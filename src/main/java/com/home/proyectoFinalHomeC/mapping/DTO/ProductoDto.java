package com.home.proyectoFinalHomeC.mapping.DTO;

import com.home.proyectoFinalHomeC.entity.normalizacion.Area;
import com.home.proyectoFinalHomeC.entity.normalizacion.Tipo_producto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductoDto {


    private Long id_tipoProducto;
    @NotBlank(message = "Falta agregar una decripcion")
    private String descripcion;
    @NotBlank(message = "El producto debe tener un nombre")
    private String nombre;
    @NotNull(message = "El producto debe estar catalogado en un tipo de producto")
    private Tipo_producto tipo_producto;
    @NotNull(message = "El  producto debe  estar asociado a una area")
    private Area area;

}
