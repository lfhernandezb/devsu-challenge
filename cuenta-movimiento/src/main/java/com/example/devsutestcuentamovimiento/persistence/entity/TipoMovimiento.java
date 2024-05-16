package com.example.devsutestcuentamovimiento.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tipo_movimiento")
public class TipoMovimiento {
    @Id
    @Column(name = "id_tipo_movimiento")
    private int tipoMovimientoId;
    private String descripcion;
}
