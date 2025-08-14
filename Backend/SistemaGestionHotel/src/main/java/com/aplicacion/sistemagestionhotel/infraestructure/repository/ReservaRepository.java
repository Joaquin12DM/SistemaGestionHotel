package com.aplicacion.sistemagestionhotel.infraestructure.repository;

import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
}
