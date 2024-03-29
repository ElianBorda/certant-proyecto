package com.certan.boutiquedelautomotor.model;

public enum CategoriaEficacia {

    ALTO_RENDIMIENTO(900.0), BASICO(600.0);

    private final Double precio;

    private CategoriaEficacia(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }
}
