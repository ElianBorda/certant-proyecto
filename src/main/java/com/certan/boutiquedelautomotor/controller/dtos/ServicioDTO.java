package com.certan.boutiquedelautomotor.controller.dtos;

import com.certan.boutiquedelautomotor.model.Servicio;
import com.certan.boutiquedelautomotor.model.Turno;

public class ServicioDTO {
    private Long id;
    private Double precio;

    private String nombreServicio;

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


}
