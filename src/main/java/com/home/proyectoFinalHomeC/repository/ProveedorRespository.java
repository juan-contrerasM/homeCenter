package com.home.proyectoFinalHomeC.repository;

import com.home.proyectoFinalHomeC.entity.Provedoor;
import com.home.proyectoFinalHomeC.entity.Pyp;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRespository  extends JpaRepository<Provedoor,Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proveedores (cedula,nombre,rut, descuento) " +
            "VALUES (:cedula, :nombre, :rut, :descuento)", nativeQuery = true)
    void guardarProvedor(String cedula, String nombre, String rut, float descuento);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long obtenerUltimoId();


    @Transactional
    @Query(value = "SELECT * FROM proveedores  WHERE cedula = :cedula   ", nativeQuery = true)
    Provedoor obtenerProveedor(String cedula);


    @Modifying
    @Transactional
    @Query(value = "UPDATE proveedores " +
            "SET cedula = :cedula, nombre = :nombre, rut = :rut, descuento = :descuento " +
            "WHERE cedula = :cedula", nativeQuery = true)
    int actualizarProveedor( String cedula, String nombre, String rut, float descuento);


    @Query(value = "SELECT * FROM proveedores ", nativeQuery = true)
    List<Provedoor> obtenerProveedores();

    @Modifying
    @Transactional
    @Query( value = "DELETE FROM proveedores WHERE cedula = :cedula",nativeQuery = true)
    int eliminarProveedor(String cedula);
}
