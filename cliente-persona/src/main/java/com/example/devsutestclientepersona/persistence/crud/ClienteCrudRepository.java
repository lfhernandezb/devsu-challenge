package com.example.devsutestclientepersona.persistence.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.devsutestclientepersona.persistence.entity.Cliente;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Long> {


    @Query(value=
            "SELECT c.*" +
            "FROM cliente c\n" +
            "LEFT JOIN persona p ON p.id_persona = c.id_persona\n" +
            "WHERE p.id_persona = :personaId"
, nativeQuery = true)
    public Optional<Cliente> findByPersonaId(
            @Param("personaId") long personaId);
}
