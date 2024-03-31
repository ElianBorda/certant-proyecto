package com.certan.boutiquedelautomotor.controller.rest;

import com.certan.boutiquedelautomotor.controller.dtos.ServicioDTO;
import com.certan.boutiquedelautomotor.controller.dtos.TurnoDTO;
import com.certan.boutiquedelautomotor.model.Servicio;
import com.certan.boutiquedelautomotor.model.Turno;
import com.certan.boutiquedelautomotor.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/servicio")
public class ServicioControllerREST {

    @Autowired
    private ServicioService servicioService;

    @GetMapping()
    private List<ServicioDTO> obtenerTodosLosServicios(){
        List<Servicio> servicios = servicioService.recuperarTodosLosServicios();
        return servicios.stream()
                .map(ServicioDTO::desdeModelo)
                .collect(Collectors.toList());
    };
}
