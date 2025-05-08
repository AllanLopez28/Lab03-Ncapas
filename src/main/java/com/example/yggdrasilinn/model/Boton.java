package com.example.yggdrasilinn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "boton")
public class Boton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Cada botón está en un piso
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "piso_id", nullable = false)
    private Piso piso;

    // Y tiene un color asociado
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "color_boton_id", nullable = false)
    private ColorBoton colorBoton;

    public Boton() { }

    public Boton(Piso piso, ColorBoton colorBoton) {
        this.piso = piso;
        this.colorBoton = colorBoton;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    public ColorBoton getColorBoton() {
        return colorBoton;
    }

    public void setColorBoton(ColorBoton colorBoton) {
        this.colorBoton = colorBoton;
    }
}
