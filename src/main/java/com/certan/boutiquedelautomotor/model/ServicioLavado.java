package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICIO_LAVADO")
public class ServicioLavado extends Servicio{

    private CategoriaLavado categoriaLavado;
    public ServicioLavado(Long precio, CategoriaLavado categoriaLavado
    ) {
        super(precio);
        this.categoriaLavado = categoriaLavado;
    }

    public CategoriaLavado getCategoriaLavado() {
        return categoriaLavado;
    }

    public void setCategoriaLavado(CategoriaLavado categoriaLavado) {
        this.categoriaLavado = categoriaLavado;
    }
}
