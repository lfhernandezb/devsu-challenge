package com.example.devsutestclientepersona.persistence.entity;

import com.example.devsutestclientepersona.persistence.crud.ClienteCrudRepository;
import com.example.devsutestclientepersona.service.ClienteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@SpringBootTest
public class ClienteTest {

    private ClienteCrudRepository clienteCrudRepository;

    @Autowired
    private ClienteService clienteService;

    @Before
    public void setUp() throws Exception {
        clienteCrudRepository = Mockito.mock(ClienteCrudRepository.class);
        //clienteService = new ClienteService();
    }

    @Test
    public void when_create_client_then_get_contrasena_is_ok() {
        // unit test
        Cliente cliente = new Cliente.ClienteBuilder().
                contrasena("1234").
                build();

        assertTrue(cliente.getContrasena().equals("1234"));
    }

    @Test
    public void when_get_existing_client_from_db_then_get_contrasena_is_ok() {
        // integration test
        Cliente cliente = clienteService.getById(5L).get();

        assertTrue(cliente.getContrasena().equals("1234567"));
    }

}