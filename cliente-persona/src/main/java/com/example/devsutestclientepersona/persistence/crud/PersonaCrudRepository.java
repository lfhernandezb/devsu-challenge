package com.example.devsutestclientepersona.persistence.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.devsutestclientepersona.persistence.entity.Persona;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonaCrudRepository extends CrudRepository<Persona, Long> {
    public Optional<Persona> findByNombre(String nombre);

    @Modifying
    @Query(value=
            "DELETE FROM persona\n" +
                    "WHERE id_persona = :personaId"
            , nativeQuery = true)
    public void deleteById(
            @Param("personaId") long personaId);
}
