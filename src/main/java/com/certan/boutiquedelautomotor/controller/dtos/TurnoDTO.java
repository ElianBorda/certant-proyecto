package com.certan.boutiquedelautomotor.controller.dtos;

import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.Servicio;
import com.certan.boutiquedelautomotor.model.Turno;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TurnoDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("fechaHora")
    private LocalDateTime fechaHora;

    @JsonProperty("cliente")
    private Cliente cliente;

    @JsonProperty("precioTotal")
    private Double precioTotal;

    @JsonProperty("serviciosContratados")
    private List<Servicio> serviciosContratados;


    public TurnoDTO(Long id, Cliente cliente, LocalDateTime fechaHora, Double precioTotal, List<Servicio>serviciosContratados) {
        this.id = id;
        this.serviciosContratados = serviciosContratados;
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        this.precioTotal = precioTotal;
    }

    public static TurnoDTO desdeModelo(Turno turno){
        return new TurnoDTO(
                turno.getId(),
                turno.getCliente(),
                turno.getFechaHora(),
                turno.getPrecioTotal(),
                turno.getServiciosContratados()
                );
    }

    public Turno aModelo(){
        Turno turno = new Turno();
        turno.setId(this.id);
        turno.setCliente(this.cliente);
        turno.setFechaHora(this.fechaHora);
        turno.setPrecioTotal(this.precioTotal);
        turno.setServiciosContratados(this.serviciosContratados);
        return turno;
    }
}
