package com.certan.boutiquedelautomotor.model.exceptions;

import org.springframework.dao.InvalidDataAccessApiUsageException;

public class NoSePuedeRecuperarLaEntidadIdNullException extends InvalidDataAccessApiUsageException {

    public NoSePuedeRecuperarLaEntidadIdNullException() {
        super("No se puede recuperar una objeto de la base de datos si el ID es null: ID = NULL");
    }
}
