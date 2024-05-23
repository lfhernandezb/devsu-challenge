package com.example.devsutestclientepersona.persistence.entity;

import com.example.devsutestclientepersona.persistence.crud.ClienteCrudRepository;
import com.example.devsutestclientepersona.persistence.crud.PersonaCrudRepository;
import com.example.devsutestclientepersona.service.ClienteService;
import com.example.devsutestclientepersona.service.PersonaService;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.Assert.*;

//@RunWith( SpringRunner.class )
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class ClienteTest {

    private final Cliente clientePepito = Cliente.builder()
            .contrasena("abcd")
            .estado(true)
            .persona(Persona.builder()
                    .edad(40)
                    .direccion("Su casa")
                    .nombre("Pepito Andrade")
                    .genero(Genero.builder()
                            .descripcion("M")
                            .build())
                    .identificacion("23456")
                    .telefono("+569111")
                    .build())
            .build();

    private final Cliente clienteJuanito = Cliente.builder()
            .contrasena("efgh")
            .estado(true)
            .persona(Persona.builder()
                    .edad(50)
                    .direccion("Su departamento")
                    .nombre("Juanito Perez")
                    .genero(Genero.builder()
                            .descripcion("M")
                            .build())
                    .identificacion("34567")
                    .telefono("+569222")
                    .build())
            .build();

    private final Cliente [] clientes = {this.clientePepito, this.clienteJuanito};

    private final List<Object> list = Arrays.asList(clientes);

    @Mock
    private ClienteCrudRepository clienteCrudRepository;

    @Mock
    private PersonaCrudRepository personaCrudRepository;

    @Mock
    private PersonaService personaService;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeAll
    public static void beforeAll() {
        MockitoAnnotations.openMocks(ClienteTest.class);
    }

    @Test
    public void whenCreateClient_thenGetContrasenaIsAsExpected() {
        // unit test
        Cliente cliente = new Cliente.ClienteBuilder().
                contrasena("1234").
                build();

        assertTrue(cliente.getContrasena().equals("1234"));
    }

    @Test
    public void whenClienteIsAdded_thenControlFlowAsExpected() {
        // integration test
        // obtengo cliente al azar de la lista
        Cliente clientetoAdd = (Cliente) this.list.get(new Random().nextInt(this.list.size()));

        Mockito.when(this.personaCrudRepository.save(Mockito.any(Persona.class)))
                .thenReturn(clientetoAdd.getPersona());

        Mockito.when(this.personaCrudRepository.save(Mockito.any(Persona.class)))
                .thenReturn(clientetoAdd.getPersona());

        Mockito.when(this.clienteCrudRepository.save(Mockito.any(Cliente.class)))
                .thenReturn(clientetoAdd);

        this.clienteService.save(clientetoAdd);

        Mockito.verify(this.clienteCrudRepository, Mockito.times(1))
                .save(Mockito.any(Cliente.class));
    }

}