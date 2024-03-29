package com.certan.boutiquedelautomotor.service;

import com.certan.boutiquedelautomotor.dao.ServicioDAO;
import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.Servicio;
import com.certan.boutiquedelautomotor.model.exceptions.LaEntidadNoPoseeIdExeption;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ServicioService {

    @Autowired
    private ServicioDAO servicioDAO;
    public Servicio crearCliente(Servicio servicio) {
        return servicioDAO.save(servicio);
    }

    public Servicio recuperarCliente(Long id) {
        Optional<Servicio> optional = servicioDAO.findById(id);
        return optional.orElse(null);
    }

    public void actualizarCliente(Servicio servicio) throws LaEntidadNoPoseeIdExeption {
        if (recuperarCliente(servicio.getId()) == null) {
            throw new LaEntidadNoPoseeIdExeption(servicio.getClass().getName());
        }
        servicioDAO.save(servicio);
    }

    public void clearAll(){
        servicioDAO.deleteAll();
    }
}
