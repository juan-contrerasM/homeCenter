package com.home.proyectoFinalHomeC.repository;


import com.home.proyectoFinalHomeC.entity.Operador;
import com.home.proyectoFinalHomeC.entity.Provedoor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operadores(cedula,nombre,apellido, fecha_nacimiento" +
            ",indicador_aislamiento) VALUES (:cedula,:nombre,:apellido," +
            ":fecha_nacimiento,:indicador_aislamiento);", nativeQuery = true)
    void guardarOperador(String cedula,
                         String nombre,
                         String apellido,
                         LocalDate fecha_nacimiento,
                         String indicador_aislamiento);


    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long obtenerUltimoId();

    @Transactional
    @Query(value = "SELECT * FROM operadores  WHERE cedula = :cedula   ", nativeQuery = true)
    Operador obtenerOperador(String cedula);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operadores " +
            "SET cedula = :cedula, nombre = :nombre, apellido = :apellido, fecha_nacimiento = :fecha_nacimiento," +
            " indicador_aislamiento = :indicador_aislamiento WHERE cedula = :cedula", nativeQuery = true)
    int actualizarOperador(String cedula,
                           String nombre,
                           String apellido,
                           LocalDate fecha_nacimiento,
                           String indicador_aislamiento);


    @Query(value = "SELECT * FROM operadores ", nativeQuery = true)
    List<Operador> obtenerOperadores();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operadores WHERE cedula = :cedula", nativeQuery = true)
    int eliminarOperador(String cedula);
}
