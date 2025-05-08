package com.example.yggdrasilinn.repository;

import com.example.yggdrasilinn.model.ColorBoton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorBotonRepository extends JpaRepository<ColorBoton, Long> {

    // 1) Query derivada: busca exacta por nombre
    Optional<ColorBoton> findByNombreColor(String nombreColor);

    // 2) Query híbrida (JPQL): busca por fragmento en el nombre (case-insensitive)
    @Query("SELECT cb FROM ColorBoton cb " +
           "WHERE LOWER(cb.nombreColor) LIKE LOWER(CONCAT('%', :fragmento, '%'))")
    List<ColorBoton> buscarPorNombreContiene(@Param("fragmento") String fragmento);

    // 3) Query nativa: busca exacta por nombre en la tabla física
    @Query(value = "SELECT * FROM color_boton " +
                   "WHERE nombre_color = :nombreColor",
           nativeQuery = true)
    Optional<ColorBoton> buscarNativePorNombre(@Param("nombreColor") String nombreColor);
}
