package com.certan.boutiquedelautomotor.controller.rest;

import com.certan.boutiquedelautomotor.controller.dtos.ClienteDTO;
import com.certan.boutiquedelautomotor.controller.dtos.TurnoDTO;
import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.Turno;
import com.certan.boutiquedelautomotor.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteControllerREST {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    private List<ClienteDTO> obtenerTodosLosCliente(){
        List<Cliente> clientes = clienteService.recuperarTodosLosClientes();
        return clientes.stream()
                .map(ClienteDTO::desdeModelo)
                .collect(Collectors.toList());
    };

}
