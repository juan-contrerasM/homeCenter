package com.home.proyectoFinalHomeC.controller;

import com.home.proyectoFinalHomeC.entity.Operador;
import com.home.proyectoFinalHomeC.entity.Provedoor;
import com.home.proyectoFinalHomeC.mapping.DTO.OperadorDto;
import com.home.proyectoFinalHomeC.mapping.DTO.ProveedorDto;
import com.home.proyectoFinalHomeC.repository.OperadorRepository;
import com.home.proyectoFinalHomeC.repository.ProveedorRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("operador/")
public class ControllerOperador {

    @Autowired
    private OperadorRepository operadorRepository;


    @PostMapping("guardarOperador")
    private ResponseEntity<?> guardarOperador(@RequestBody @Valid OperadorDto operadorDto) {

        operadorRepository.guardarOperador(operadorDto.getCedula(),
                operadorDto.getNombre(),
                operadorDto.getApellido(),
                LocalDate.now(),
                operadorDto.getIndicador_aislamiento());
        return ResponseEntity.ok(operadorDto);
    }

    @PutMapping("actualizarOperador/{cedula}")//eliminar----------------
    private ResponseEntity<?> actualizarOperador(@PathVariable String cedula, @RequestBody @Valid OperadorDto operadorDto) {
        int filasAfectadas = operadorRepository.actualizarOperador(cedula,
                operadorDto.getNombre(),
                operadorDto.getApellido(),
                LocalDate.now(),
                operadorDto.getIndicador_aislamiento());
        if (filasAfectadas > 0) {
            Operador operador = operadorRepository.obtenerOperador(cedula);
            return ResponseEntity.ok().body(operador);
        } else {
            return ResponseEntity.badRequest().body("no hay un operador registrado con ese id");
        }
    }

    @GetMapping("obtenerOperador/{cedula}")
    private ResponseEntity<?> obtenerOperador(@PathVariable String cedula) {
        Operador operador = operadorRepository.obtenerOperador(cedula);
        if (operador != null) {
            return ResponseEntity.ok().body(operador);
        } else {
            return ResponseEntity.badRequest().body("El operador con este id no se encuentra");
        }
    }

    @GetMapping("obtenerOperadores")
    private ResponseEntity<?> obtenerOperadores() {
        List<Operador> operadores = operadorRepository.obtenerOperadores();
        if (!operadores.isEmpty()) {
            return ResponseEntity.ok().body(operadores);
        } else {
            return ResponseEntity.badRequest().body("No hay operadores registrados");
        }
    }

    @DeleteMapping("eliminarOperador/{cedula}")
    private ResponseEntity<?> eliminarOperador(@PathVariable String cedula) {
        int filaModificadas = operadorRepository.eliminarOperador(cedula);
        if (filaModificadas > 0) {
            return ResponseEntity.ok().body("el operador ha sido eliminado");
        } else {
            return ResponseEntity.ok().body("No hay un operador registrado con ese id");
        }
    }
}


