package com.example.yggdrasilinn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "salon_evento")
public class SalonEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(columnDefinition = "TEXT")
    private String ornamentos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;

    public SalonEvento() { }

    public SalonEvento(String nombre, Integer capacidad, String ornamentos, Sucursal sucursal) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ornamentos = ornamentos;
        this.sucursal = sucursal;
    }

    // getters y setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public String getOrnamentos() { return ornamentos; }
    public void setOrnamentos(String ornamentos) { this.ornamentos = ornamentos; }

    public Sucursal getSucursal() { return sucursal; }
    public void setSucursal(Sucursal sucursal) { this.sucursal = sucursal; }
}
