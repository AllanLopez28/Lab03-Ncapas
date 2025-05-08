package com.example.yggdrasilinn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cuarto")
public class Cuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private boolean chimenea;

    @Column(nullable = false)
    private boolean biblioteca;

    @Column(nullable = false)
    private boolean balcon;

    // Cada cuarto pertenece a un piso
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "piso_id", nullable = false)
    private Piso piso;

    public Cuarto() { }

    public Cuarto(String nombre,
                  String descripcion,
                  boolean chimenea,
                  boolean biblioteca,
                  boolean balcon,
                  Piso piso) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.chimenea = chimenea;
        this.biblioteca = biblioteca;
        this.balcon = balcon;
        this.piso = piso;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    public boolean isBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(boolean biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }
}
