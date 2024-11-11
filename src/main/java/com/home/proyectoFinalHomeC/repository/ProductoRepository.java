package com.home.proyectoFinalHomeC.repository;

import com.home.proyectoFinalHomeC.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{
    @Query("SELECT p FROM Producto p WHERE p.nombre = :nombre AND p.id_producto = :id_producto")
    Optional<Producto> productoDuplicado(String nombre, Long id_producto);


}

