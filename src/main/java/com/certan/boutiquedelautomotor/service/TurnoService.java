package com.certan.boutiquedelautomotor.service;

import com.certan.boutiquedelautomotor.dao.ClienteDAO;
import com.certan.boutiquedelautomotor.dao.TurnoDAO;
import com.certan.boutiquedelautomotor.model.Cliente;
import com.certan.boutiquedelautomotor.model.Turno;
import com.certan.boutiquedelautomotor.model.exceptions.LaEntidadNoPoseeIdExeption;
import com.certan.boutiquedelautomotor.model.exceptions.NoSePuedeRecuperarLaEntidadIdNullException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TurnoService {

    @Autowired
    private TurnoDAO turnoDAO;

    @Autowired
    private ClienteDAO clienteDAO;

    public Turno crearTurno(Turno turno) {
        Turno turnoCreado = turnoDAO.save(turno);
        Boolean esPremium = turnoDAO.esPremium(turnoCreado.getCliente().getId());

        if (esPremium){
            turnoCreado.getCliente().setEsPremium(true);
            clienteDAO.save(turnoCreado.getCliente());
        }
        return turnoCreado;
    }

    public Turno recuperarTurno(Long id) {
        if (id == null){
            throw new NoSePuedeRecuperarLaEntidadIdNullException();
        }
        Optional<Turno> optional = turnoDAO.findById(id);
        return optional.orElse(null);
    }

    public void actualizarTurno(Turno turno) throws LaEntidadNoPoseeIdExeption {
        if (recuperarTurno(turno.getId()) == null) {
            throw new LaEntidadNoPoseeIdExeption(turno.getClass().getName());
        }
        turnoDAO.save(turno);
    }

    public Boolean elClienteEsPremium(Cliente cliente){
        return turnoDAO.esPremium(cliente.getId());
    }
    public List<Turno> recuperarTodosLosTurnos(){
        return (List<Turno>) turnoDAO.findAll();
    }
    public void clearAll(){
        turnoDAO.deleteAll();
    }
}
