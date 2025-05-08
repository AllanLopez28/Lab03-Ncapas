package com.example.yggdrasilinn.repository;

import com.example.yggdrasilinn.model.Regalia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegaliaRepository extends JpaRepository<Regalia, Long> {
}
