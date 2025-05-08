package com.example.yggdrasilinn.repository;

import com.example.yggdrasilinn.model.Cuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuartoRepository extends JpaRepository<Cuarto, Long> {

    // 1) Query derivada: todos los cuartos de un piso
    List<Cuarto> findByPisoId(Long pisoId);

    // 2) Query híbrida (JPQL): busca por fragmento en el nombre (case-insensitive)
    @Query("SELECT c FROM Cuarto c " +
           "WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :fragmento, '%'))")
    List<Cuarto> buscarPorNombreContiene(@Param("fragmento") String fragmento);

    // 3) Query nativa: filtra cuartos según tengan chimenea o no
    @Query(value = 
      "SELECT * FROM cuarto " +
      "WHERE chimenea = :chimenea",
      nativeQuery = true)
    List<Cuarto> buscarNativePorChimenea(@Param("chimenea") boolean chimenea);
}
