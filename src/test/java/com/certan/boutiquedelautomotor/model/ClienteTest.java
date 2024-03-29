package com.certan.boutiquedelautomotor.model;


import com.certan.boutiquedelautomotor.model.exceptions.LaEntidadNoPoseeIdExeption;
import com.certan.boutiquedelautomotor.model.exceptions.PatenteDeVehiculoNoValidaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente joseRodriguez;
    private Turno turno1;


    @BeforeEach
    void setUp(){
        this.joseRodriguez = new Cliente("Jose", "Rodriguez", "AA111AA");
        this.turno1 = Mockito.mock(Turno.class);
    }

    @Test
    void seVerificaQueUnClientePuedeRecordarSusTurnos(){
        this.joseRodriguez.agregarTurno(this.turno1);
        assertEquals(this.joseRodriguez.cantidadDeTurnos(), 1);
    }

    @Test
    void seVerificaQueLaPatenteDeVehiculoEsValidoParaElFormatoAAA111(){
        Cliente clienteValido = new Cliente("Alberto", "Miguel", "REM123");

        assertNotNull(clienteValido);
    }

    @Test
    void seVerificaQueLaPatenteDeVehiculoEsValidoParaElFormatoAA111AA(){
        Cliente clienteValido = new Cliente("Alberto", "Miguel", "DU321DU");

        assertNotNull(clienteValido);
    }

    @Test
    void seVerificaQueCuandoLaPatenteDeVehiculoNoEsValidaLevantaUnaExcepcion(){
        assertThrows(PatenteDeVehiculoNoValidaException.class, () -> {
            new Cliente("Alberto", "Miguel", "13IJD232");
        });
    }
}
