package com.certan.boutiquedelautomotor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
