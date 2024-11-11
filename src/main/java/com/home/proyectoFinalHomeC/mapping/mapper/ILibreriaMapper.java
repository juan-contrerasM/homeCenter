package com.home.proyectoFinalHomeC.mapping.mapper;

import com.home.proyectoFinalHomeC.entity.Producto;
import com.home.proyectoFinalHomeC.mapping.DTO.ProductoDto;
import org.springframework.stereotype.Component;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ILibreriaMapper {
    //empelado
    @IterableMapping(qualifiedByName = "LibrotoLibroDto")
    List<ProductoDto> getProductoDto(List<Producto> lista);

    @Named("LibrotoLibroDto")
    ProductoDto ProductotoProductoDto(Producto producto);

    @Named("LibroDtotoLibro")
    Producto ProductoDtotoProducto(ProductoDto productoDto);

}
