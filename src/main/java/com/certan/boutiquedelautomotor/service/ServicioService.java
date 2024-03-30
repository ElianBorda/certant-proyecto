package com.certan.boutiquedelautomotor.service;

import com.certan.boutiquedelautomotor.dao.ServicioDAO;
import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.Servicio;
import com.certan.boutiquedelautomotor.model.exceptions.LaEntidadNoPoseeIdExeption;
import com.certan.boutiquedelautomotor.model.exceptions.NoSePuedeRecuperarLaEntidadIdNullException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ServicioService {

    @Autowired
    private ServicioDAO servicioDAO;
    public Servicio crearServicio(Servicio servicio) {
        return servicioDAO.save(servicio);
    }

    public Servicio recuperarServicio(Long id) {
        if (id == null){
            throw new NoSePuedeRecuperarLaEntidadIdNullException();
        }
        Optional<Servicio> optional = servicioDAO.findById(id);
        return optional.orElse(null);
    }

    public void actualizarServicio(Servicio servicio) throws LaEntidadNoPoseeIdExeption {
        if (recuperarServicio(servicio.getId()) == null) {
            throw new LaEntidadNoPoseeIdExeption(servicio.getClass().getName());
        }
        servicioDAO.save(servicio);
    }

    public void clearAll(){
        servicioDAO.deleteAll();
    }
}
