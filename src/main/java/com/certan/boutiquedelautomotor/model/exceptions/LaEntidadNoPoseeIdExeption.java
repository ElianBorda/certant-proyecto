package com.certan.boutiquedelautomotor.model.exceptions;

public class LaEntidadNoPoseeIdExeption extends RuntimeException{
    public LaEntidadNoPoseeIdExeption(String entidad) {
        super("La entidad " + entidad + "no se puede actualizar porque no posee id: ID = NULL");
    }
}
