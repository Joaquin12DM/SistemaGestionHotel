package com.aplicacion.sistemagestionhotel.infraestructure.repository;

import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<HabitacionEntity, Long> {


    @Query("SELECT h FROM HabitacionEntity h " +
            "WHERE h.idHabitacion NOT IN (" +
            "  SELECT r.habitacion.idHabitacion FROM ReservaEntity r " +
            "  WHERE (r.fechaEntrada <= :fechaSalida AND r.fechaSalida >= :fechaEntrada)" +
            ")")
    List<HabitacionEntity> findDisponiblesByFechas(@Param("fechaEntrada") LocalDate fechaEntrada,
                                                   @Param("fechaSalida") LocalDate fechaSalida);

    @Query("SELECT h FROM HabitacionEntity h WHERE h.tipo = :tipo")
    List<HabitacionEntity> findAllByTipo(@Param("tipo") String tipo);
}
