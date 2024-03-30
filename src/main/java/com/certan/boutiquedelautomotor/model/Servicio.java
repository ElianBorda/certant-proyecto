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

    public Servicio(Double precio) {
        this.precio = precio;
    }
    public Servicio() {}

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
