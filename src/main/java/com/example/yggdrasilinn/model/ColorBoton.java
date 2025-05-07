package com.example.yggdrasilinn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "color_boton")
public class ColorBoton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_color", nullable = false, unique = true)
    private String nombreColor;

    public ColorBoton() { }

    public ColorBoton(String nombreColor) {
        this.nombreColor = nombreColor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreColor() { return nombreColor; }
    public void setNombreColor(String nombreColor) { this.nombreColor = nombreColor; }
}
