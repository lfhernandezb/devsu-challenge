package com.example.devsutestclientepersona.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.devsutestclientepersona.persistence.entity.Cliente;

import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Long> {
    public Optional<Cliente> findByPersonaId(long personaId);
}
