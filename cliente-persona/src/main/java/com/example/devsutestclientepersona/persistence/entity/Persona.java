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
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private long personaId;
    private String nombre;
    //@Column(name = "id_genero")
    //private int generoId;

    @JsonIgnoreProperties("personas")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genero", insertable = false, updatable = false)
    private Genero genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;

    /*
    @JsonIgnoreProperties("persona")
    @OneToOne(fetch=FetchType.EAGER, mappedBy="persona", cascade=CascadeType.PERSIST) // (cascade = {CascadeType.ALL})
    private Cliente cliente;
    */

}
