package com.aplicacion.sistemagestionhotel.repository;

import com.aplicacion.sistemagestionhotel.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
