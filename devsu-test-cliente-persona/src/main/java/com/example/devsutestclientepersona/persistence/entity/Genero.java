package com.example.devsutestclientepersona.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
