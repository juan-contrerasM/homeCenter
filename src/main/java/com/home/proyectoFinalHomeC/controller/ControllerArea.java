package com.home.proyectoFinalHomeC.controller;

import com.home.proyectoFinalHomeC.entity.Pyp;
import com.home.proyectoFinalHomeC.entity.normalizacion.Area;
import com.home.proyectoFinalHomeC.mapping.DTO.AreaDto;
import com.home.proyectoFinalHomeC.mapping.DTO.PypDto;
import com.home.proyectoFinalHomeC.repository.AreaRepository;
import com.home.proyectoFinalHomeC.repository.PypRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("area/")
public class ControllerArea {

    @Autowired//-----------------------
    private PypRepository pypRepository;//------------

    @Autowired
    private AreaRepository areaRepository;

    @PostMapping("guardarArea")
    private ResponseEntity<?> guardarArea(@RequestBody@Valid AreaDto areaDto){
        Area area= new Area();
        area.setNombre(areaDto.getNombre());
        area.setDescripcion(areaDto.getDescripcion());
        areaRepository.guardarArea(area.getId_area(),area.getNombre(),area.getDescripcion());
        area.setId_area(areaRepository.obtenerUltimoId());
        return ResponseEntity.ok(area);
    }

    @PutMapping("actualizarArea/{id_area}")
    private ResponseEntity<?> actualizarArea(@PathVariable Long id_area ,@RequestBody @Valid  AreaDto areaDto){
        int filasAfectadas = areaRepository.actualizarArea(id_area, areaDto.getNombre(), areaDto.getDescripcion());
        if (filasAfectadas > 0) {
            Area area=areaRepository.obtenerArea(id_area);
            return ResponseEntity.ok().body(area);
        }
        else {
            return ResponseEntity.badRequest().body("no hay un area registrado con ese id");
        }

    }
    @GetMapping("obtenerArea/{id_area}")
    private ResponseEntity<?>obtenerArea(@PathVariable Long id_area ){
        Area area= areaRepository.obtenerArea(id_area);
        if(area!= null){
            return ResponseEntity.ok().body(area);
        }
        else {
            return ResponseEntity.badRequest().body("El area con este id no se encuentra");
        }
    }

    @GetMapping("obtenerAreas")
    private ResponseEntity<?>obtenerAreas(){
        List<Area> areas= areaRepository.obtenerAreas();
        if(!areas.isEmpty()){
            return ResponseEntity.ok().body(areas);
        }
        else {
            return ResponseEntity.badRequest().body("No hay areas registrados");
        }
    }

    @DeleteMapping("eliminarArea/{id_area}")
    private ResponseEntity<?>eliminarArea(@PathVariable Long id_area){
        int filaModificadas= areaRepository.eliminarArea(id_area);
        if(filaModificadas>0){
            return ResponseEntity.ok().body("el area ha sido eliminado");
        }
        else {
            return ResponseEntity.ok().body("No hay un area registrado con ese id");
        }
    }




}
