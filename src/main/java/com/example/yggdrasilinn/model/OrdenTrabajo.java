package com.example.yggdrasilinn.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cuarto_id", nullable = false)
    private Cuarto cuarto;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    public OrdenTrabajo() { }

    public OrdenTrabajo(Persona persona, Cuarto cuarto,
                        LocalDateTime fechaHora, String descripcion) {
        this.persona = persona;
        this.cuarto = cuarto;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
    }

    // getters y setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public Cuarto getCuarto() { return cuarto; }
    public void setCuarto(Cuarto cuarto) { this.cuarto = cuarto; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
