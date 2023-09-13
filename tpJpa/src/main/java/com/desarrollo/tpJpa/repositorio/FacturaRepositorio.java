package com.desarrollo.tpJpa.repositorio;

import com.desarrollo.tpJpa.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepositorio extends JpaRepository <Factura,Long> {
}
