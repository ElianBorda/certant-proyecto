package com.certan.boutiquedelautomotor.model.exceptions;

public class PatenteDeVehiculoNoValidaException extends RuntimeException{

    public PatenteDeVehiculoNoValidaException(String patenteDeVehiculo){
        super("La patente de vehiculo " + patenteDeVehiculo +  " no tiene el formato valido AAA111 o AA111AA");
    }
}
