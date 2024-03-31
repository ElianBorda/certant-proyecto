package com.certan.boutiquedelautomotor.controller.dtos;

import com.certan.boutiquedelautomotor.model.Servicio;
import com.certan.boutiquedelautomotor.model.Turno;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ServicioDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("precio")
    private Double precio;

    @JsonProperty("nombreServicio")
    private String nombreServicio;

    @JsonProperty("turno")
    private Turno turno;

    public ServicioDTO(Long id, Double precio, String nombreServicio, Turno turno) {
        this.id = id;
        this.precio = precio;
        this.nombreServicio = nombreServicio;
        this.turno = turno;
    }

    public static ServicioDTO desdeModelo(Servicio servicio){
        return new ServicioDTO(
                servicio.getId(),
                servicio.getPrecio(),
                servicio.getNombreServicio(),
                servicio.getTurno()
        );
    }

    public Servicio aModelo(){

        Servicio servicio = new Servicio();
        servicio.setId(this.id);
        servicio.setPrecio(this.precio);
        servicio.setNombreServicio(this.nombreServicio);
        servicio.setTurno(this.turno);

        return servicio;

    }


}
