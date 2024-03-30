package com.certan.boutiquedelautomotor.service;

import com.certan.boutiquedelautomotor.model.*;
import com.certan.boutiquedelautomotor.model.exceptions.LaEntidadNoPoseeIdExeption;
import com.certan.boutiquedelautomotor.model.exceptions.NoSePuedeRecuperarLaEntidadIdNullException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TurnoServicesTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ServicioService servicioService;


    private Cliente ramonGalarza;
    private Cliente joseRodriguez;
    private Servicio alineacionYBalanceo;
    private Servicio cambioDeAceite;
    private ArrayList<Servicio> servicios;
    private Turno turno;


    @BeforeEach
    void setUp(){

        this.ramonGalarza        = this.clienteService.crearCliente(new Cliente("Ramon", "Galarza", "EIA293"));
        this.joseRodriguez       = this.clienteService.crearCliente(new Cliente("Jose", "Rodriguez", "AA111AA"));

        this.alineacionYBalanceo = this.servicioService.crearServicio(new ServicioAlineacionBalanceo(true));
        this.cambioDeAceite      = this.servicioService.crearServicio(new ServicioCambioAceiteYFiltro(CategoriaEficacia.ALTO_RENDIMIENTO, Motor.NAFTEROS));

        this.servicios           = new ArrayList<>();
        this.servicios.add(this.alineacionYBalanceo);
        this.servicios.add(this.cambioDeAceite);

        this.turno = new Turno(this.servicios, this.ramonGalarza);

    }

    @Test
    void seVerificaQueSePuedeGuardarUnTurnoEnLaBaseDeDatos(){
        Turno turnoGuardado = this.turnoService.crearTurno(this.turno);
        assertNotNull(turnoGuardado.getId());
    }

    @Test
    void seVerificaQueSePuedeRecuperarUnTurnoEnLaBaseDeDatos(){
        Turno turnoGuardado = this.turnoService.crearTurno(this.turno);
        Turno turnoRecuperado = this.turnoService.recuperarTurno(turnoGuardado.getId());

        assertEquals(turnoRecuperado.getId(), turnoGuardado.getId());
        assertEquals(turnoRecuperado.getPrecioTotal(), turnoGuardado.getPrecioTotal());
        assertEquals(turnoRecuperado.getFechaHora(), turnoGuardado.getFechaHora());
        assertEquals(turnoRecuperado.cantidadDeServicios(), turnoGuardado.cantidadDeServicios());
    }

    @Test
    void seVerificaQueSiSeQuiereRecuperarUnTurnoConUnIdNullLevantaUnaExcepcion() {
        assertThrows(NoSePuedeRecuperarLaEntidadIdNullException.class, () -> {
            turnoService.recuperarTurno(null);
        });
    }

    @Test
    void seVerificaQueSePuedeActualizaUnTurnoEnLaBaseDeDatos(){

        LocalDate fecha = LocalDate.of(2003, 2, 21);
        Turno turnoGuardado = this.turnoService.crearTurno(this.turno);
        assertNotEquals(turnoGuardado.getFechaHora(), fecha);

        turnoGuardado.setFechaHora(fecha);
        this.turnoService.actualizarTurno(turnoGuardado);
        Turno turnoActualizado = this.turnoService.recuperarTurno(turnoGuardado.getId());

        assertEquals(turnoActualizado.getId(), turnoGuardado.getId());
        assertEquals(turnoActualizado.getFechaHora(), fecha);
    }

    @Test
    void seVerificaQueSiSeQuiereActualizarUnTurnoConUnIdQueNoExisteEnLaBaseDeDatosSeLevantaUnaExcepcion(){

        assertThrows(LaEntidadNoPoseeIdExeption.class, () -> {
            Turno turnoConId = turnoService.crearTurno(this.turno);
            this.tearDown();
            turnoService.actualizarTurno(turnoConId);
        });
    }

    @AfterEach
    void tearDown(){
        this.turnoService.clearAll();
        this.clienteService.clearAll();
        this.servicioService.clearAll();
    }
}
