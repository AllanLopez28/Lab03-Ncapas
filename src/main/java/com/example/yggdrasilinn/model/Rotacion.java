package com.example.yggdrasilinn.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rotacion")
public class Rotacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "piso_id", nullable = false)
    private Piso piso;

    @Column(nullable = false)
    private String turno;

    @Column(nullable = false)
    private LocalDate mes;

    @Column(nullable = false)
    private boolean activa;

    public Rotacion() { }

    public Rotacion(Persona persona, Piso piso, String turno, LocalDate mes, boolean activa) {
        this.persona = persona;
        this.piso = piso;
        this.turno = turno;
        this.mes = mes;
        this.activa = activa;
    }

    // getters y setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public Piso getPiso() { return piso; }
    public void setPiso(Piso piso) { this.piso = piso; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public LocalDate getMes() { return mes; }
    public void setMes(LocalDate mes) { this.mes = mes; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
}
