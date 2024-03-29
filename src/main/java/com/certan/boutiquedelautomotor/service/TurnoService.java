package com.certan.boutiquedelautomotor.service;

import com.certan.boutiquedelautomotor.dao.TurnoDAO;
import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.Turno;
import com.certan.boutiquedelautomotor.model.exceptions.LaEntidadNoPoseeIdExeption;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class TurnoService {

    @Autowired
    private TurnoDAO turnoDAO;
    public Turno crearCliente(Turno turno) {
        return turnoDAO.save(turno);
    }

    public Turno recuperarCliente(Long id) {
        Optional<Turno> optional = turnoDAO.findById(id);
        return optional.orElse(null);
    }

    public void actualizarCliente(Turno turno) throws LaEntidadNoPoseeIdExeption {
        if (recuperarCliente(turno.getId()) == null) {
            throw new LaEntidadNoPoseeIdExeption(turno.getClass().getName());
        }
        turnoDAO.save(turno);
    }

    public void clearAll(){
        turnoDAO.deleteAll();
    }
}
