package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICIO_ALINEACION_Y_BALANCEO")
public class ServicioAlineacionBalanceo extends Servicio{

    private Boolean incluyeCambioDeCubiertas;


    public ServicioAlineacionBalanceo(){

    }

    public ServicioAlineacionBalanceo(Boolean incluyeCambioDeCubiertas) {
        super(incluyeCambioDeCubiertas ? 900.0 : 400.0);
        this.incluyeCambioDeCubiertas = incluyeCambioDeCubiertas;
    }

    public Boolean getIncluyeCambioDeCubiertas() {
        return incluyeCambioDeCubiertas;
    }

    public void setIncluyeCambioDeCubiertas(Boolean incluyeCambioDeCubiertas) {
        this.incluyeCambioDeCubiertas = incluyeCambioDeCubiertas;
    }
}
