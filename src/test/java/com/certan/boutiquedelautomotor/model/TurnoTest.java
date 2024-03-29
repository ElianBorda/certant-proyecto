package com.certan.boutiquedelautomotor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnoTest {

    private Turno turno;
    private Cliente joseRodriguez;
    private Cliente ramonGalarza;
    private Servicio alineacionYBalanceo;
    private ArrayList<Servicio> servicios;
    private ServicioCambioAceiteYFiltro cambioDeAceite;

    @BeforeEach
    void setUp(){
        this.ramonGalarza = new Cliente("Ramon", "Galarza", "EIA293");
        this.joseRodriguez = new Cliente("Jose", "Rodriguez", "AA111AA");

        this.alineacionYBalanceo = new ServicioAlineacionBalanceo(true);
        this.cambioDeAceite = new ServicioCambioAceiteYFiltro(CategoriaEficacia.ALTO_RENDIMIENTO, Motor.NAFTEROS);

        this.servicios = new ArrayList<>();
        this.servicios.add(this.alineacionYBalanceo);
        this.servicios.add(this.cambioDeAceite);

        this.turno = new Turno(this.servicios, this.ramonGalarza);
    }

    @Test
    void seVerificaQueCuandoSeCreaUnTurnoEsteRecuerdaElServicioYElClienteLoRecibe(){

        assertEquals(this.joseRodriguez.cantidadDeTurnos(), 0);

        ArrayList<Servicio> servicios =  new ArrayList<>();
        servicios.add(this.alineacionYBalanceo);

        Turno turno = new Turno(servicios, this.joseRodriguez);

        assertEquals(turno.cantidadDeServicios(), 1);
        assertEquals(this.joseRodriguez.cantidadDeTurnos(), 1);
    }

    @Test
    void seVerficaQueElTurnoTeIndicaElPrecioTotalDeLosServiciosQueSolicitoElCliente(){
        assertEquals(this.turno.getPrecioTotal(), 2250.0);
    }
}
