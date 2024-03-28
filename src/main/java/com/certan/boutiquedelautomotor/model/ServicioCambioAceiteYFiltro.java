package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICIO_CAMBIO_DE_ACEITE_Y_FILTRO")
public class ServicioCambioAceiteYFiltro extends Servicio {

    private CategoriaEficacia categoria;
    private Motor motor;

    public ServicioCambioAceiteYFiltro(Long precio, CategoriaEficacia categoria, Motor motor) {
        super(precio);
        this.categoria = categoria;
        this.motor     = motor;
    }

    public CategoriaEficacia getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEficacia categoria) {
        this.categoria = categoria;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
