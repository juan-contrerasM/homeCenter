package com.home.proyectoFinalHomeC.service;

import com.home.proyectoFinalHomeC.entity.Producto;
import com.home.proyectoFinalHomeC.exception.ExceptionRegistroDuplicado;
import com.home.proyectoFinalHomeC.mapping.DTO.ProductoDto;
import com.home.proyectoFinalHomeC.mapping.mapper.ILibreriaMapper;
import com.home.proyectoFinalHomeC.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;
    ILibreriaMapper iLibreriaMapper = Mappers.getMapper(ILibreriaMapper.class);


    //metodo guardar libro
    public ProductoDto guardarProducto(ProductoDto productoDto) {
        Optional<Producto> productoExiste = productoRepository.productoDuplicado(productoDto.getNombre(), productoDto.getArea().getId_area());// revision de que no haya libro duplicados
        if (productoExiste.isPresent()) {// si hay libros registrados con esos datos lazamos exception
            log.debug("Intento de guardar un producto que ya esta registrado en el sistema,  nombre: {},area: {} Id de producto registrado: {}", productoDto.getNombre(), productoDto.getArea().getNombre(), productoExiste.get().getId_producto());
            throw new ExceptionRegistroDuplicado("El libro ya existe en el catalogo");
        } else {// de lo contrario se resgitrara el libro
            Producto producto = iLibreriaMapper.ProductoDtotoProducto(productoDto);// mappeamos
            productoRepository.save(producto);// guardamaos en la base de datos
            log.info("Libro se ha guardado correctamente \n Id: {} ,Titulo: {}", producto.getId_producto(), producto.getNombre());
            return iLibreriaMapper.ProductotoProductoDto(producto);
        }

    }
}











