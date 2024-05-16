package com.example.devsutestclientepersona.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
