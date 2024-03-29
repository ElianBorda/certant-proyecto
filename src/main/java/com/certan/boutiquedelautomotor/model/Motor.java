package com.certan.boutiquedelautomotor.model;

public enum Motor {
    DIESEL(400.0), NAFTEROS(450.0);

    private final Double precio;

    private Motor(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }
}
