package com.certan.boutiquedelautomotor.model;

public enum CategoriaLavado {
    BASICO(300.0), COMPLETO(500.0), PREMIUM(800.0);

    private final Double precio;

    private CategoriaLavado(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }
}
