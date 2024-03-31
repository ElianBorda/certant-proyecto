package com.certan.boutiquedelautomotor.controller.rest;

import com.certan.boutiquedelautomotor.controller.dtos.TurnoDTO;
import com.certan.boutiquedelautomotor.model.Turno;
import com.certan.boutiquedelautomotor.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/turno")
public class TurnoControllerREST {

    @Autowired
    private TurnoService turnoService;

    @GetMapping()
    private List<TurnoDTO> obtenerTodosLosTurnos(){
        List<Turno> turnos = turnoService.recuperarTodosLosTurnos();
        return turnos.stream()
                .map(TurnoDTO::desdeModelo)
                .collect(Collectors.toList());
    };
}
