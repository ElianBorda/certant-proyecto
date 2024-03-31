package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICIO_CAMBIO_DE_ACEITE_Y_FILTRO")
public class ServicioCambioAceiteYFiltro extends Servicio {

    @Enumerated(EnumType.STRING)
    private CategoriaEficacia categoria;

    @Enumerated(EnumType.STRING)
    private Motor motor;


    public ServicioCambioAceiteYFiltro(){

    }
    public ServicioCambioAceiteYFiltro(CategoriaEficacia categoria, Motor motor) {
        super(categoria.getPrecio() + motor.getPrecio(), "Servicio de Cambio de Aceite y Filtro");
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
