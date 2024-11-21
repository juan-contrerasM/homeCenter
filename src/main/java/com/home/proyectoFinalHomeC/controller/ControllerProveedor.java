package com.home.proyectoFinalHomeC.controller;


import com.home.proyectoFinalHomeC.entity.Provedoor;
import com.home.proyectoFinalHomeC.entity.Pyp;
import com.home.proyectoFinalHomeC.mapping.DTO.ProveedorDto;
import com.home.proyectoFinalHomeC.mapping.DTO.PypDto;
import com.home.proyectoFinalHomeC.repository.ProveedorRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proveedor/")
public class ControllerProveedor {

    @Autowired
    private ProveedorRespository proveedorRespository;

    @PostMapping("guardarProveedor")
    private ResponseEntity<?> guardarProveedor(@RequestBody @Valid ProveedorDto proveedorDto){
        System.out.println(proveedorDto.getDescuento());
        proveedorRespository.guardarProvedor(proveedorDto.getCedula(),proveedorDto.getNombre(),proveedorDto.getRut(),proveedorDto.getDescuento());
        return ResponseEntity.ok(proveedorDto);
    }

    @PutMapping("actualizarProveedor/{cedula}")
    private ResponseEntity<?> actualizarProveedor(@PathVariable String cedula ,@RequestBody @Valid  ProveedorDto proveedorDto){
        int filasAfectadas = proveedorRespository.actualizarProveedor(cedula, proveedorDto.getNombre(), proveedorDto.getRut(), proveedorDto.getDescuento());
        if (filasAfectadas > 0) {
            Provedoor provedoor=proveedorRespository.obtenerProveedor(cedula);
            return ResponseEntity.ok().body(provedoor);
        }
        else {
            return ResponseEntity.badRequest().body("no hay un proveedor registrado con ese id");
        }

    }
    @GetMapping("obtenerProveedor/{cedula}")
    private ResponseEntity<?>obtenerProveedor(@PathVariable String cedula ){
        Provedoor provedoor= proveedorRespository.obtenerProveedor(cedula);
        if(provedoor!= null){
            return ResponseEntity.ok().body(provedoor);
        }
        else {
            return ResponseEntity.badRequest().body("El proveedor con este id no se encuentra");
        }
    }

    @GetMapping("obtenerProveedores")
    private ResponseEntity<?>obtenerProvedores(){
        List<Provedoor> provedoores= proveedorRespository.obtenerProveedores();
        if(!provedoores.isEmpty()){
            return ResponseEntity.ok().body(provedoores);
        }
        else {
            return ResponseEntity.badRequest().body("No hay proveedores registrados");
        }
    }

    @DeleteMapping("eliminarProveedor/{cedula}")
    private ResponseEntity<?>eliminarProveedor(@PathVariable String  cedula){
        int filaModificadas= proveedorRespository.eliminarProveedor(cedula);
        if(filaModificadas>0){
            return ResponseEntity.ok().body("el proveedor ha sido eliminado");
        }
        else {
            return ResponseEntity.ok().body("No hay un proveedor registrado con ese id");
        }
    }


}
