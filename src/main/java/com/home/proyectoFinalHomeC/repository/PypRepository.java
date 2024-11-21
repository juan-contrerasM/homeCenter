package com.home.proyectoFinalHomeC.repository;


import com.home.proyectoFinalHomeC.entity.Pyp;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PypRepository extends JpaRepository<Pyp, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pyps (id_pyp, cedula, nombre, cantida_recuperaciones, pypcol) " +
            "VALUES (:id_pyp, :cedula, :nombre, :cantidad_recuperaciones, :pypcol)", nativeQuery = true)
    void guardarProducto(Long id_pyp, String cedula, String nombre, int cantidad_recuperaciones, String pypcol);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long obtenerUltimoId();


    @Transactional
    @Query(value = "SELECT * FROM pyps WHERE id_pyp = :id_pyp   ", nativeQuery = true)
    Pyp obtenerPyp(Long id_pyp);


    @Modifying
    @Transactional
    @Query(value = "UPDATE pyps " +
            "SET cedula = :cedula, nombre = :nombre, cantida_recuperaciones = :cantida_recuperaciones, pypcol = :pypcol " +
            "WHERE id_pyp = :id_pyp", nativeQuery = true)
    int actualizarPyp(Long id_pyp, String cedula, String nombre, int cantida_recuperaciones, String pypcol);


    @Query(value = "SELECT * FROM pyps", nativeQuery = true)
    List<Pyp> obtenerPyps();

    @Modifying
    @Transactional
    @Query( value = "DELETE FROM pyps WHERE id_pyp = :id_pyp",nativeQuery = true)
    int eliminarPyp(Long id_pyp);

}
