package com.example.yggdrasilinn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "regalia")
public class Regalia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "puntos_costo", nullable = false)
    private Integer puntosCosto;

    public Regalia() { }

    public Regalia(String nombre, String descripcion, Integer puntosCosto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntosCosto = puntosCosto;
    }

    // getters y setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getPuntosCosto() { return puntosCosto; }
    public void setPuntosCosto(Integer puntosCosto) { this.puntosCosto = puntosCosto; }
}
