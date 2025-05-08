package com.example.yggdrasilinn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_rol", nullable = false, unique = true)
    private String nombreRol;

    public Rol() { }

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    // getters y setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreRol() { return nombreRol; }
    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }
}
