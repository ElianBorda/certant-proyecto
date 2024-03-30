package com.certan.boutiquedelautomotor.service;

import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.Servicio;
import com.certan.boutiquedelautomotor.model.exceptions.LaEntidadNoPoseeIdExeption;
import com.certan.boutiquedelautomotor.model.exceptions.NoSePuedeRecuperarLaEntidadIdNullException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.fail;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    private Cliente joseRodriguez;

    @BeforeEach
    void setUp(){
        this.joseRodriguez = new Cliente("Jose", "Rodriguez", "AA111AA");

    }

    @Test
    void seVerificaQueSePudeGuardarEnLaBaseDeDatosElCliente() {
        Cliente clienteGuardado = clienteService.crearCliente(joseRodriguez);
        Assertions.assertNotNull(clienteGuardado.getId());
    }

    @Test
    void seVerificaQueSePudeRecuperarElClienteEnLaBaseDeDatos() {
        Cliente clienteGuardado = clienteService.crearCliente(joseRodriguez);

        Cliente clienteRecuperado = clienteService.recuperarCliente(clienteGuardado.getId());

        assertEquals(clienteRecuperado.getId(), clienteGuardado.getId());
        assertEquals(clienteRecuperado.getNombre(), clienteGuardado.getNombre());
        assertEquals(clienteRecuperado.getApellido(), clienteGuardado.getApellido());
        assertEquals(clienteRecuperado.getPatenteVehiculo(), clienteGuardado.getPatenteVehiculo());
    }

    @Test
    void seVerificaQueSiSeQuiereRecuperarUnClienteConUnIdNullLevantaUnaExcepcion() {
        assertThrows(NoSePuedeRecuperarLaEntidadIdNullException.class, () -> {
            clienteService.recuperarCliente(null);
        });
    }

    @Test
    void seVerificaQueSePudeActualizarElClienteEnLaBaseDeDatos() {
        String nuevoNombre = "Ricardo";
        String nuevoApellido = "Borda";
        String nuevoVehiculo = "AA122AA";

        Cliente clienteGuardado = clienteService.crearCliente(joseRodriguez);
        clienteGuardado.setNombre(nuevoNombre);
        clienteGuardado.setApellido(nuevoApellido);
        clienteGuardado.setPatenteVehiculo(nuevoVehiculo);

        clienteService.actualizarCliente(clienteGuardado);


        Cliente clienteActualizado = clienteService.recuperarCliente(clienteGuardado.getId());
        assertEquals(nuevoNombre, clienteActualizado.getNombre());
        assertEquals(nuevoApellido, clienteActualizado.getApellido());
        assertEquals(nuevoVehiculo, clienteActualizado.getPatenteVehiculo());
    }

    @Test
    void seVerificaQueSiSeQuiereActualizarUnClienteConUnIdQueNoExisteEnLaBaseDeDatosLevantaUnaExcepcion() {
        assertThrows(LaEntidadNoPoseeIdExeption.class, () -> {
            Cliente clienteConId = clienteService.crearCliente(this.joseRodriguez);
            this.clienteService.clearAll();
            clienteService.actualizarCliente(clienteConId);
        });
    }


    @AfterEach
    void tearDown() {
       this.clienteService.clearAll();
    }
}
