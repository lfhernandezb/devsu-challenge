package com.example.devsutestclientepersona.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @Column(name = "id_genero")
    private int generoId;
    private String abreviacion;
    private String descripcion;

    @JsonIgnoreProperties("genero")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genero", cascade = CascadeType.ALL)
    private List<Persona> personas;
}
