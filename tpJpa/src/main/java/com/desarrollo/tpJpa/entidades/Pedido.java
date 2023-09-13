package com.desarrollo.tpJpa.entidades;

import com.desarrollo.tpJpa.enumeraciones.EstadoPedido;
import com.desarrollo.tpJpa.enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido extends BaseEntidad{

    private EstadoPedido estadoPedido;
    private Date fecha;
    private TipoEnvio tipoEnvio;
    private Double total;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default

    private List<DetallePedido> detalles = new ArrayList<>();

    public void  agregarDetalle(DetallePedido det){
        detalles.add(det);
    }

    public void mostrarDetalles(){
        System.out.println("Detalles del pedido: ");
        for (DetallePedido detalle: detalles){
            System.out.println("Cantidad: " + detalle.getCantidad() + ", Subtotal: " + detalle.getSubtotal() );
        }
    }

}
