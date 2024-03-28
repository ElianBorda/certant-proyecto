package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
@Inheritance(strategy = InheritanceType.JOINED)
public class Servicio {
    private Long precio;

    public Servicio(Long precio) {
        this.precio = precio;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
