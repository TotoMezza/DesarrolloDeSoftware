package com.desarrollo.tpJpa.repositorio;

import com.desarrollo.tpJpa.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepositorio extends JpaRepository<Domicilio,Long> {
}
