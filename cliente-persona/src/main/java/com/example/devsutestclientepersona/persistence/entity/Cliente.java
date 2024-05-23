package com.example.devsutestclientepersona.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long clienteId;
    private String contrasena;
    private boolean estado;
    //@Column(name = "id_persona")
    //private long personaId;

    @JsonIgnoreProperties("cliente")
    //@OneToOne(fetch = FetchType.EAGER)
    @OneToOne(fetch=FetchType.EAGER) //, mappedBy="cliente", cascade=CascadeType.PERSIST)
    //@MapsId("personaId")
    @JoinColumn(name = "id_persona") //, insertable = false, updatable = false)
    private Persona persona;
}
