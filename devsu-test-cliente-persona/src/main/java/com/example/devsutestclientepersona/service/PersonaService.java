package com.example.devsutestclientepersona.service;

import com.example.devsutestclientepersona.persistence.crud.PersonaCrudRepository;
import com.example.devsutestclientepersona.persistence.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaCrudRepository personaCrudRepository;

    public List<Persona> getAll() {
        return (List<Persona>) personaCrudRepository.findAll();
    }

    public Optional<Persona> getById(long id) {
        return personaCrudRepository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return personaCrudRepository.findByNombre(nombre);
    }

    public Persona save(Persona persona) {
        return personaCrudRepository.save(persona);
    }

    public boolean delete(long id) {
        return getById(id).map((persona) -> {
            personaCrudRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
