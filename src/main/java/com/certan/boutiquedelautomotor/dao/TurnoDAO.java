package com.certan.boutiquedelautomotor.dao;

import com.certan.boutiquedelautomotor.model.Turno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoDAO extends CrudRepository<Turno, Long> {
}
