package com.desarrollo.tpJpa.repositorio;

import com.desarrollo.tpJpa.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido,Long> {
}
