package com.certan.boutiquedelautomotor.service;

import com.certan.boutiquedelautomotor.model.*;
import com.certan.boutiquedelautomotor.model.exceptions.LaEntidadNoPoseeIdExeption;
import com.certan.boutiquedelautomotor.model.exceptions.NoSePuedeRecuperarLaEntidadIdNullException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServiciosServiceTest {

    @Autowired
    private ServicioService servicioService;
    private Servicio servicioAlineacionBalanceo;
    private Servicio servicioLavado;
    private Servicio servicioCambioDeAceite;

    @BeforeEach
    void setUp(){
        this.servicioAlineacionBalanceo = new ServicioAlineacionBalanceo(true);
        this.servicioLavado = new ServicioLavado(CategoriaLavado.BASICO);
        this.servicioCambioDeAceite = new ServicioCambioAceiteYFiltro(CategoriaEficacia.BASICO, Motor.NAFTEROS);
    }

    @Test
    void seVerificaQueSePuedeGuardarTodosLosServicioEnLaBaseDeDatos(){

        Servicio servicioGuardado = this.servicioService.crearServicio(this.servicioAlineacionBalanceo);
        Servicio servicioGuardado2 = this.servicioService.crearServicio(this.servicioLavado);
        Servicio servicioGuardado3 = this.servicioService.crearServicio(this.servicioCambioDeAceite);

        assertNotNull(servicioGuardado.getId());
        assertNotNull(servicioGuardado2.getId());
        assertNotNull(servicioGuardado3.getId());
    }

    @Test
    void seVerificaQueSePuedeRecuperarElServicioDeLaBaseDeDatos(){
        Servicio servicioGuardado = servicioService.crearServicio(this.servicioLavado);

        Servicio servicioRecuperado = servicioService.recuperarServicio(servicioGuardado.getId());

        assertEquals(servicioRecuperado.getId(), servicioGuardado.getId());
        assertEquals(servicioRecuperado.getPrecio(), servicioGuardado.getPrecio());
    }

    @Test
    void seVerificaQueSiSeQuiereRecuperarUnServicioConUnIdNullLevantaUnaExcepcion() {
        assertThrows(NoSePuedeRecuperarLaEntidadIdNullException.class, () -> {
            servicioService.recuperarServicio(null);
        });
    }

    @Test
    void seVerificaQueSePuedeActualizaElServicioEnLaBaseDeDatos(){

        Servicio servicioGuardado = this.servicioService.crearServicio(this.servicioLavado);

        assertEquals(servicioGuardado.getPrecio(), 300.0);

        servicioGuardado.setPrecio(233.0);
        servicioService.actualizarServicio(servicioGuardado);
        Servicio servicioActualizado = this.servicioService.recuperarServicio(servicioGuardado.getId());
        assertEquals(servicioActualizado.getPrecio(), 233.0);
    }

    @Test
    void seVerificaQueSiSeQuiereActualizarUnServicioConUnIdQueNoExisteEnLaBaseDeDatosSeLevantaUnaExcepcion(){

        assertThrows(LaEntidadNoPoseeIdExeption.class, () -> {
            Servicio servicioConId = servicioService.crearServicio(this.servicioLavado);
            this.servicioService.clearAll();
            servicioService.actualizarServicio(servicioConId);
        });
    }

    @AfterEach
    void tearDown(){
        this.servicioService.clearAll();
    }
}
