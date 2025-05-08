package com.example.yggdrasilinn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "piso")
public class Piso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Relación a ColorBoton
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "color_boton_id", nullable = false)
    private ColorBoton colorBoton;

    // Relación a Sucursal
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;

    public Piso() { }

    public Piso(String nombre, ColorBoton colorBoton, Sucursal sucursal) {
        this.nombre = nombre;
        this.colorBoton = colorBoton;
        this.sucursal = sucursal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ColorBoton getColorBoton() {
        return colorBoton;
    }

    public void setColorBoton(ColorBoton colorBoton) {
        this.colorBoton = colorBoton;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
