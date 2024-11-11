package com.home.proyectoFinalHomeC.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


public class Cliente {



    private Long cedula;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;

}
