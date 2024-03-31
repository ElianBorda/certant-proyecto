package com.certan.boutiquedelautomotor.controller.rest;

import com.certan.boutiquedelautomotor.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteControllerREST {

    @Autowired
    private ClienteService clienteService;

}
