package com.example.devsutestclientepersona.persistence.entity;

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
    @Column(name = "id_persona")
    private long personaId;
    //@OneToOne(fetch = FetchType.EAGER)
    @OneToOne
    @MapsId("personaId")
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    private Persona persona;
}
