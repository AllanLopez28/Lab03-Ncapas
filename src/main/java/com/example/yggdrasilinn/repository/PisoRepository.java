package com.example.yggdrasilinn.repository;

import com.example.yggdrasilinn.model.Piso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PisoRepository extends JpaRepository<Piso, Long> {

    // 1) Query derivada: lista todos los pisos de una sucursal
    List<Piso> findBySucursalId(Long sucursalId);

    // 2) Query híbrida (JPQL): busca pisos cuyo nombre contenga un fragmento (case-insensitive)
    @Query("SELECT p FROM Piso p " +
           "WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :fragmento, '%'))")
    List<Piso> buscarPorNombreContiene(@Param("fragmento") String fragmento);

    // 3) Query nativa: lista pisos por color de botón (FK)
    @Query(value = 
      "SELECT * FROM piso " +
      "WHERE color_boton_id = :colorId",
      nativeQuery = true)
    List<Piso> buscarPorColorBotonNative(@Param("colorId") Long colorId);
}
