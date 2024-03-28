package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICIO_ALINEACION_Y_BALANCEO")
public class SevicioAlineacionBalanceo extends Servicio{

    private Boolean incluyeCambioDeCubiertas;
    public SevicioAlineacionBalanceo(Long precio, Boolean incluyeCambioDeCubiertas) {
        super(precio);
        this.incluyeCambioDeCubiertas = incluyeCambioDeCubiertas;
    }

    public Boolean getIncluyeCambioDeCubiertas() {
        return incluyeCambioDeCubiertas;
    }

    public void setIncluyeCambioDeCubiertas(Boolean incluyeCambioDeCubiertas) {
        this.incluyeCambioDeCubiertas = incluyeCambioDeCubiertas;
    }
}
