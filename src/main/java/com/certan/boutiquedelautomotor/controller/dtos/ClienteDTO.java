package com.certan.boutiquedelautomotor.controller.dtos;

import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.Turno;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.cj.xdevapi.Client;

import java.util.ArrayList;

public class ClienteDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("patenteVehiculo")
    private String patenteVehiculo;

    @JsonProperty("esPremium")
    private Boolean esPremium;


    public ClienteDTO(Long id, String nombre, String apellido, String patenteVehiculo, Boolean esPremium) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.patenteVehiculo = patenteVehiculo;
        this.esPremium = esPremium;
    }

    public static ClienteDTO desdeModelo(Cliente cliente){

        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getPatenteVehiculo(),
                cliente.getEsPremium());

    }

    public Cliente aModelo(){
        Cliente cliente = new Cliente();
            cliente.setId(this.id);
            cliente.setNombre(this.nombre);
            cliente.setApellido(this.apellido);
            cliente.setPatenteVehiculo(this.patenteVehiculo);
            cliente.setEsPremium(this.esPremium);
            return cliente;
    }
}
