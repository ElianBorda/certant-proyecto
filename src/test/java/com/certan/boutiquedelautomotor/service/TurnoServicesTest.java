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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private Turno turno2;
    private List<Servicio> servicios2;
    private ArrayList<Servicio> servicios3;
    private Cliente clientePremium;
    private Turno turno3;


    @BeforeEach
    void setUp(){

        this.ramonGalarza        = this.clienteService.crearCliente(new Cliente("Ramon", "Galarza", "EIA293"));
        this.joseRodriguez       = this.clienteService.crearCliente(new Cliente("Jose", "Rodriguez", "AA111AA"));
        this.clientePremium       = this.clienteService.crearCliente(new Cliente("Miguel", "Balbuena", "AFS224"));

        this.alineacionYBalanceo = new ServicioAlineacionBalanceo(true);
        this.cambioDeAceite      = new ServicioCambioAceiteYFiltro(CategoriaEficacia.ALTO_RENDIMIENTO, Motor.NAFTEROS);


        this.servicios           = new ArrayList<>();
        this.servicios.add(this.alineacionYBalanceo);
        this.servicios2          = new ArrayList<>();
        this.servicios2.add(this.cambioDeAceite);
        this.servicios3          = new ArrayList<>();
        this.servicios3.add(new ServicioCambioAceiteYFiltro(CategoriaEficacia.ALTO_RENDIMIENTO, Motor.NAFTEROS));
        this.servicios3.add(new ServicioCambioAceiteYFiltro(CategoriaEficacia.ALTO_RENDIMIENTO, Motor.NAFTEROS));
        this.servicios3.add(new ServicioCambioAceiteYFiltro(CategoriaEficacia.ALTO_RENDIMIENTO, Motor.NAFTEROS));
        this.servicios3.add(new ServicioCambioAceiteYFiltro(CategoriaEficacia.ALTO_RENDIMIENTO, Motor.NAFTEROS));
        this.servicios3.add(new ServicioCambioAceiteYFiltro(CategoriaEficacia.ALTO_RENDIMIENTO, Motor.NAFTEROS));

        this.turno = new Turno(LocalDateTime.of(2023,05,15,15,12), this.servicios, this.ramonGalarza);
        this.turno2 = new Turno(LocalDateTime.of(2023,07,15,15,12), this.servicios2, this.joseRodriguez);
        this.turno3 = new Turno(LocalDateTime.of(2021,03,15,15,12), this.servicios3, this.clientePremium);


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
    void seVerificaQueSePudeRecuperarTodosLosElementosDeLaBaseDeDatos(){
        this.turnoService.crearTurno(this.turno);
        this.turnoService.crearTurno(this.turno2);

        List<Turno> turnos = this.turnoService.recuperarTodosLosTurnos();
        assertEquals(turnos.size(), 2);
    }

    @Test
    void seVerificaQueSiSeQuiereRecuperarUnTurnoConUnIdNullLevantaUnaExcepcion() {
        assertThrows(NoSePuedeRecuperarLaEntidadIdNullException.class, () -> {
            turnoService.recuperarTurno(null);
        });
    }

    @Test
    void seVerificaQueSePuedeActualizaUnTurnoEnLaBaseDeDatos(){

        LocalDateTime fecha = LocalDateTime.of(2024, 3, 12, 23, 32);
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

    @Test
    void seVerificaQueUnClienteDadoNoEsPremiumPorqueTieneMenosDe5Servicios(){
        Turno turno = this.turnoService.crearTurno(this.turno);
        this.turnoService.crearTurno(this.turno2);


        assertFalse(this.turnoService.elClienteEsPremium(turno.getCliente()));
    }

    @Test
    void seVerificaQueUnClienteDadoEsPremiumPorqueTieneMasDe5Servicios(){
        Turno turno = this.turnoService.crearTurno(this.turno3);
        this.turnoService.crearTurno(this.turno2);


        assertTrue(this.turnoService.elClienteEsPremium(turno.getCliente()));
        assertTrue(turno.getCliente().getEsPremium());
    }

    @AfterEach
    void tearDown(){
        /*this.turnoService.clearAll();
        this.clienteService.clearAll();
        this.servicioService.clearAll();*/
    }
}
