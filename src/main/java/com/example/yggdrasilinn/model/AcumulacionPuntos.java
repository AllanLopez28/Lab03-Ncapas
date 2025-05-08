package com.example.yggdrasilinn.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "acumulacion_puntos")
public class AcumulacionPuntos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "regalia_id", nullable = false)
    private Regalia regalia;

    @Column(name = "puntos_otorgados", nullable = false)
    private Integer puntosOtorgados;

    @Column(nullable = false)
    private LocalDateTime fecha;

    public AcumulacionPuntos() { }

    public AcumulacionPuntos(Persona persona, Regalia regalia,
                             Integer puntosOtorgados, LocalDateTime fecha) {
        this.persona = persona;
        this.regalia = regalia;
        this.puntosOtorgados = puntosOtorgados;
        this.fecha = fecha;
    }

    // getters y setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public Regalia getRegalia() { return regalia; }
    public void setRegalia(Regalia regalia) { this.regalia = regalia; }

    public Integer getPuntosOtorgados() { return puntosOtorgados; }
    public void setPuntosOtorgados(Integer puntosOtorgados) { this.puntosOtorgados = puntosOtorgados; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
