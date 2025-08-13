package com.aplicacion.sistemagestionhotel.repository;

import com.aplicacion.sistemagestionhotel.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
}
