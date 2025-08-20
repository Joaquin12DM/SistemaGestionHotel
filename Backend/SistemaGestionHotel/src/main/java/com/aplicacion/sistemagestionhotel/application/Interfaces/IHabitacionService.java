package com.aplicacion.sistemagestionhotel.application.Interfaces;


import com.aplicacion.sistemagestionhotel.domain.enums.EstadoHabitacion;
import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IHabitacionService {

    List<Habitacion> findAll();
    Optional<Habitacion> findById(Long id);
    Habitacion save(Habitacion habitacion);
    void deleteById(Long id);

    List<Habitacion> findDisponiblesByFecha(LocalDate fecha);
}
