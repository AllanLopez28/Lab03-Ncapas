package com.example.yggdrasilinn.repository;

import com.example.yggdrasilinn.model.Boton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BotonRepository extends JpaRepository<Boton, Long> {

    // 1) Query derivada: todos los botones de un piso dado
    List<Boton> findByPisoId(Long pisoId);

    // 2) Query híbrida (JPQL): botones cuyo nombre de color coincida (case-insensitive)
    @Query("SELECT b FROM Boton b " +
           "WHERE LOWER(b.colorBoton.nombreColor) = LOWER(:nombreColor)")
    List<Boton> buscarPorNombreColor(@Param("nombreColor") String nombreColor);

    // 3) Query nativa: botones por id de color en la tabla física
    @Query(value = 
      "SELECT * FROM boton " +
      "WHERE color_boton_id = :colorId",
      nativeQuery = true)
    List<Boton> buscarNativePorColorId(@Param("colorId") Long colorId);
}
