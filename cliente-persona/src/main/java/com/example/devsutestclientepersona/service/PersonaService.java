package com.example.devsutestclientepersona.service;

import com.example.devsutestclientepersona.persistence.crud.PersonaCrudRepository;
import com.example.devsutestclientepersona.persistence.entity.Persona;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonaService {

    private final Logger logger = Logger.getLogger(PersonaService.class.getName());
    @Autowired
    private PersonaCrudRepository personaCrudRepository;

    public List<Persona> getAll() {
        return (List<Persona>) personaCrudRepository.findAll();
    }

    public Optional<Persona> getById(long id) {
        logger.info("getById called");
        return personaCrudRepository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return personaCrudRepository.findByNombre(nombre);
    }

    @Transactional
    public Persona save(Persona persona) {
        return personaCrudRepository.save(persona);
    }

    @Transactional
    public boolean delete(long id) {
        logger.info("delete called");
        return getById(id).map((persona) -> {
            logger.info("found persona to delete");
            personaCrudRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
