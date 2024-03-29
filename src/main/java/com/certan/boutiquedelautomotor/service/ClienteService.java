package com.certan.boutiquedelautomotor.service;

import com.certan.boutiquedelautomotor.dao.ClienteDAO;
import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.exceptions.LaEntidadNoPoseeIdExeption;
import com.certan.boutiquedelautomotor.model.exceptions.NoSePuedeRecuperarLaEntidadIdNullException;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    public Cliente crearCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    public Cliente recuperarCliente(Long id) throws NoSePuedeRecuperarLaEntidadIdNullException {
        if (id == null){
            throw new NoSePuedeRecuperarLaEntidadIdNullException();
        }
        Optional<Cliente> optional = clienteDAO.findById(id);
        return optional.orElse(null);
    }

    public void actualizarCliente(Cliente cliente) throws LaEntidadNoPoseeIdExeption {
        Cliente clienteRecuperado = recuperarCliente(cliente.getId());
        if (clienteRecuperado == null) {
            throw new LaEntidadNoPoseeIdExeption(cliente.getClass().getName());
        } else {
            clienteDAO.save(cliente);
        }
    }

    public void clearAll(){
        clienteDAO.deleteAll();
    }
}
