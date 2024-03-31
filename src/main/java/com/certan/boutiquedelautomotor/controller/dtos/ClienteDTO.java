package com.certan.boutiquedelautomotor.controller.dtos;

import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.Turno;
import com.mysql.cj.xdevapi.Client;

import java.util.ArrayList;

public class ClienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String patenteVehiculo;


    public ClienteDTO(Long id, String nombre, String apellido, String patenteVehiculo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.patenteVehiculo = patenteVehiculo;
    }

    public static ClienteDTO desdeModelo(Cliente cliente){

        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getPatenteVehiculo());

    }
}
