package com.example.devsutestclientepersona.service;

import com.example.devsutestclientepersona.persistence.crud.ClienteCrudRepository;
import com.example.devsutestclientepersona.persistence.crud.PersonaCrudRepository;
import com.example.devsutestclientepersona.persistence.entity.Cliente;
import com.example.devsutestclientepersona.persistence.entity.Persona;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteService {

    private final Logger logger = Logger.getLogger(ClienteService.class.getName());

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Autowired
    private PersonaCrudRepository personaCrudRepository;

    public List<Cliente> getAll() {
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    public Optional<Cliente> getById(long id) {
        logger.info("getById called");
        return clienteCrudRepository.findById(id);
    }

    public Optional<Cliente> getByNombre(String nombre) {
        if (personaCrudRepository.findByNombre(nombre).isPresent()) {
            Persona persona = personaCrudRepository.findByNombre(nombre).get();

            return clienteCrudRepository.findByPersonaId(persona.getPersonaId());
        }
        else {
            return Optional.empty();
        }
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        Persona persona = personaCrudRepository.save(cliente.getPersona());
        cliente.setPersona(persona);
        //cliente.setPersonaId(persona.getPersonaId());
        return clienteCrudRepository.save(cliente);
    }

    @Transactional
    public boolean delete(long id) {
        logger.info("delete called");
        return getById(id).map((cliente) -> {
            logger.info("found cliente to delete");
            clienteCrudRepository.deleteById(id);
            personaCrudRepository.deleteById(cliente.getPersona().getPersonaId());
            return true;
        }).orElse(false);
    }
}
