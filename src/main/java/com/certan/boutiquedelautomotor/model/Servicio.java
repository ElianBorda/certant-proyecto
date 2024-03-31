package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SERVICIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precio;

    private String nombreServicio;

    @ManyToOne
    private Turno turno;

    public Servicio(Double precio, String nombreServicio) {
        this.precio = precio;
        this.nombreServicio = nombreServicio;
    }
    public Servicio() {}

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public Turno getTurno() {
        return turno;
    }

    public Long getId() {
        return id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
