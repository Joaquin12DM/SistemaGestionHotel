package com.aplicacion.sistemagestionhotel.infraestructure.repository;

import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    @Query(value = "SELECT COUNT(*) FROM reserva WHERE MONTH(fecha_entrada) = :mes AND YEAR(fecha_entrada) = :anio", nativeQuery = true)
    Long obtenerNumeroReservasPorMes(@Param("mes") int mes, @Param("anio") int anio);

    @Query(value = "SELECT COALESCE(SUM(h.precio_por_noche), 0) " +
            "FROM reserva r " +
            "JOIN habitacion h ON r.id_habitacion = h.id_habitacion " +
            "WHERE MONTH(r.fecha_entrada) = :mes AND YEAR(r.fecha_entrada) = :anio",
            nativeQuery = true)
    Double obtenerSumaMontoPorMes(@Param("mes") int mes, @Param("anio") int anio);
}
