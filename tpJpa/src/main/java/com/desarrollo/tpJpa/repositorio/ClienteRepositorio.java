package com.desarrollo.tpJpa.repositorio;

import com.desarrollo.tpJpa.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {

}
