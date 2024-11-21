package com.home.proyectoFinalHomeC.controller;

import com.home.proyectoFinalHomeC.entity.Pyp;
import com.home.proyectoFinalHomeC.mapping.DTO.PypDto;
import com.home.proyectoFinalHomeC.repository.PypRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pyp/")
public class ControllerPyp {

    @Autowired
    private PypRepository pypRepository;


    @PostMapping("guardarPyp")
    private ResponseEntity<?> guardarPyp(@RequestBody@Valid PypDto pypDto){
        Pyp pyp=new Pyp();
        pyp.setCedula(pypDto.getCedula());
        pyp.setPypcol(pypDto.getPypcol());
        pyp.setCantida_recuperaciones(pypDto.getCantida_recuperaciones());
        pyp.setNombre(pypDto.getNombre());
        pypRepository.guardarProducto(pyp.getId_pyp(),pyp.getCedula(),pyp.getNombre(),pyp.getCantida_recuperaciones(),pyp.getPypcol());
        pyp.setId_pyp(pypRepository.obtenerUltimoId());
        return ResponseEntity.ok(pyp);
    }

    @PutMapping("actualizarPyp/{id}")
    private ResponseEntity<?> actualizarPyp(@PathVariable Long id ,@RequestBody @Valid  PypDto pypDto){
        int filasAfectadas = pypRepository.actualizarPyp(id, pypDto.getCedula(), pypDto.getNombre(), pypDto.getCantida_recuperaciones(), pypDto.getPypcol());
        if (filasAfectadas > 0) {
            Pyp pyp=pypRepository.obtenerPyp(id);
            return ResponseEntity.ok().body(pyp);
        }
        else {
            return ResponseEntity.badRequest().body("no hay un pyp registrado con ese id");
        }

    }
    @GetMapping("obtenerPyp/{id}")
    private ResponseEntity<?>obtenerPyp(@PathVariable Long id ){
        Pyp pyp= pypRepository.obtenerPyp(id);
        if(pyp!= null){
            return ResponseEntity.ok().body(pyp);
        }
        else {
            return ResponseEntity.badRequest().body("El pyp con este id no se encuentra");
        }
    }

    @GetMapping("obtenerPyps")
    private ResponseEntity<?>obtenerPyps(){
        List<Pyp> pyps= pypRepository.obtenerPyps();
        if(!pyps.isEmpty()){
            return ResponseEntity.ok().body(pyps);
        }
        else {
            return ResponseEntity.badRequest().body("No hay pyps registrados");
        }
    }

    @DeleteMapping("eliminarPyp/{id}")
    private ResponseEntity<?>eliminarPyp(@PathVariable Long id){
        int filaModificadas= pypRepository.eliminarPyp(id);
        if(filaModificadas>0){
            return ResponseEntity.ok().body("el pyp ha sido eliminado");
        }
        else {
            return ResponseEntity.ok().body("No hay un pyp registrado con ese id");
        }
    }




}
