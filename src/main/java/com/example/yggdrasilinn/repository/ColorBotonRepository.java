package com.example.yggdrasilinn.repository;

import com.example.yggdrasilinn.model.ColorBoton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorBotonRepository extends JpaRepository<ColorBoton, Long> {
}
