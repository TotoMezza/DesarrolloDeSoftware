package com.desarrollo.tpJpa.repositorio;

import com.desarrollo.tpJpa.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
}
