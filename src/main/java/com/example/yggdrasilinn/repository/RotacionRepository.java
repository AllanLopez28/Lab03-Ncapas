package com.example.yggdrasilinn.repository;

import com.example.yggdrasilinn.model.Rotacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotacionRepository extends JpaRepository<Rotacion, Long> {
}
