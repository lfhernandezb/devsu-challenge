package com.example.devsutestclientepersona.persistence.crud;

import com.example.devsutestclientepersona.persistence.entity.Cliente;
import com.example.devsutestclientepersona.persistence.entity.Persona;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/*
the @Transactional annotation to ensure that changes are rolled back after each test, even if they're not made in a repository method
 */
//@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class ClienteCrudRepositoryTest {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Autowired
    private PersonaCrudRepository personaCrudRepository;

    @Test
    public void a() {
        Persona p = Persona.builder()
                .nombre("John")
                .edad(40)
                .telefono("555467")
                .build();

        Cliente c = Cliente.builder()
                .contrasena("1234")
                .estado(true)
                .build();

        personaCrudRepository.save(p);

        c.setPersona(p);

        clienteCrudRepository.save(c);

        assertTrue(personaCrudRepository.findAll().iterator().hasNext());

        assertTrue(personaCrudRepository.findAll().iterator().next().getNombre().equals("John"));

        assertTrue(clienteCrudRepository.findAll().iterator().hasNext());

        assertTrue(clienteCrudRepository.findAll().iterator().next().getContrasena().equals("1234"));
    }
}