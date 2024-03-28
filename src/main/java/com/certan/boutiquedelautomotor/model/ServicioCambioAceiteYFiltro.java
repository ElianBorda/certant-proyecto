package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cambio_aceite_y_filtro")
public class ServicioCambioAceiteYFiltro extends Servicio {
    public ServicioCambioAceiteYFiltro(Long precio) {
        super(precio);
    }
}
