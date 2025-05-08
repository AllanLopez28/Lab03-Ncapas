package com.example.yggdrasilinn.repository;

import com.example.yggdrasilinn.model.AcumulacionPuntos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcumulacionPuntosRepository extends JpaRepository<AcumulacionPuntos, Long> {
}
