package com.home.proyectoFinalHomeC.repository;


import com.home.proyectoFinalHomeC.entity.Pyp;
import com.home.proyectoFinalHomeC.entity.normalizacion.Area;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO areas (id_area,nombre,descripcion) " +
            "VALUES (:id_area, :nombre, :descripcion)", nativeQuery = true)
    void guardarArea(Long id_area, String nombre, String descripcion);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long obtenerUltimoId();


    @Transactional
    @Query(value = "SELECT * FROM areas WHERE id_area = :id_area   ", nativeQuery = true)
    Area obtenerArea(Long id_area);


    @Modifying
    @Transactional
    @Query(value = "UPDATE areas " +
            "SET nombre = :nombre, descripcion = :descripcion " +
            "WHERE id_area = :id_area", nativeQuery = true)
    int actualizarArea(Long id_area, String nombre, String descripcion);


    @Query(value = "SELECT * FROM areas", nativeQuery = true)
    List<Area> obtenerAreas();

    @Modifying
    @Transactional
    @Query( value = "DELETE FROM areas WHERE id_area = :id_area",nativeQuery = true)
    int eliminarArea(Long id_area);

}
