package com.example.devsutestclientepersona.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.example.devsutestclientepersona.persistence.entity.Persona;

import java.util.Optional;

public interface PersonaCrudRepository extends CrudRepository<Persona, Long> {
    public Optional<Persona> findByNombre(String nombre);
}
