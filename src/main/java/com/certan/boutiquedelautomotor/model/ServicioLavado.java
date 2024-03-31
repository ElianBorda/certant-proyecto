package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICIO_LAVADO")
public class ServicioLavado extends Servicio{

    @Enumerated(EnumType.STRING)
    private CategoriaLavado categoriaLavado;

    public ServicioLavado(){

    }
    public ServicioLavado(CategoriaLavado categoriaLavado
    ) {
        super(categoriaLavado.getPrecio(), "Servicio de lavado");
        this.categoriaLavado = categoriaLavado;
    }

    public CategoriaLavado getCategoriaLavado() {
        return categoriaLavado;
    }

    public void setCategoriaLavado(CategoriaLavado categoriaLavado) {
        this.categoriaLavado = categoriaLavado;
    }
}
