package com.desarrollo.tpJpa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Detalle")
public class DetallePedido extends BaseEntidad{

    private int cantidad;

    private Double subtotal;

    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;

}
