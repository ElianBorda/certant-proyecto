package com.certan.boutiquedelautomotor.dao;

import com.certan.boutiquedelautomotor.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends CrudRepository<Cliente, Long> {

}
