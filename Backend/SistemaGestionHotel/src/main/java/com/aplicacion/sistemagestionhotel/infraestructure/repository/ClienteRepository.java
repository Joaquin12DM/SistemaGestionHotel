package com.aplicacion.sistemagestionhotel.infraestructure.repository;

import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByDni(String dni);

}
