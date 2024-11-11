package com.home.proyectoFinalHomeC.controller;

import com.home.proyectoFinalHomeC.mapping.DTO.ProductoDto;
import com.home.proyectoFinalHomeC.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/producto")
@RestController
public class ControllerProducto {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/guardarProducto")
    public ResponseEntity<?> guardarLibro(@RequestBody @Valid ProductoDto productoDto){

            return ResponseEntity.ok().body(productoService.guardarProducto(productoDto));




    }


}
