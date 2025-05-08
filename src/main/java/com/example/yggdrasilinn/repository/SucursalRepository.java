package com.example.yggdrasilinn.repository;

import com.example.yggdrasilinn.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    // 1) Query derivada: lista por ubicación exacta
    List<Sucursal> findByUbicacion(String ubicacion);

    // 2) Query híbrida (JPQL): busca por fragmento en el nombre (case-insensitive)
    @Query("SELECT s FROM Sucursal s " +
           "WHERE LOWER(s.nombre) LIKE LOWER(CONCAT('%', :prefijo, '%'))")
    List<Sucursal> buscarPorNombreParcial(@Param("prefijo") String prefijo);

    // 3) Query nativa: lista por ubicación exacta sobre la tabla física
    @Query(value = "SELECT * FROM sucursal " +
                   "WHERE ubicacion = :ubicacion",
           nativeQuery = true)
    List<Sucursal> buscarNativePorUbicacion(@Param("ubicacion") String ubicacion);
}
