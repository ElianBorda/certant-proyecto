package com.certan.boutiquedelautomotor.dao;

import com.certan.boutiquedelautomotor.model.Turno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoDAO extends CrudRepository<Turno, Long> {

    @Query(
            """
               SELECT COUNT(s.id) >= 5 AS es_premium
               FROM Cliente c
               JOIN Turno t ON c.id = t.cliente.id 
               JOIN Servicio s ON t.id = s.turno.id
               WHERE c.id = :idCliente
            """
    )
    public Boolean esPremium(Long idCliente);
}
