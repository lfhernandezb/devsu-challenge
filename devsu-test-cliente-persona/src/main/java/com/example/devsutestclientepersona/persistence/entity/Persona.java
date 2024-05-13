package com.example.devsutestclientepersona.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column(name = "id_genero")
    private int generoId;
    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genero", insertable = false, updatable = false)
    private Genero genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    //@OneToOne(mappedBy = "persona", cascade = {CascadeType.ALL})
    //private Cliente cliente;


}
