package com.certan.boutiquedelautomotor.model;

import com.certan.boutiquedelautomotor.model.exceptions.PatenteDeVehiculoNoValidaException;

import java.util.regex.Pattern;

public class ValidadorDePatente {

    public static String validarPatente(String patenteDeVehiculo){
        String regex = "^[A-Z]{3}\\d{3}|[A-Z]{2}\\d{3}[A-Z]{2}$";

        if (!Pattern.matches(regex, patenteDeVehiculo)){
            throw new PatenteDeVehiculoNoValidaException(patenteDeVehiculo);
        } else {
            return patenteDeVehiculo;
        }
    }
}
