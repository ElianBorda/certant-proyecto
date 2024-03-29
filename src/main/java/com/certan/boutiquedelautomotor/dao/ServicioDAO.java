package com.certan.boutiquedelautomotor.dao;

import com.certan.boutiquedelautomotor.model.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioDAO extends CrudRepository<Servicio, Long> {
}
