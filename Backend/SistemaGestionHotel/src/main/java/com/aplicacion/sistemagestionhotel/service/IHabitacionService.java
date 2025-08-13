package com.aplicacion.sistemagestionhotel.service;

import com.aplicacion.sistemagestionhotel.entity.Habitacion;

import java.util.List;
import java.util.Optional;

public interface IHabitacionService {

    List<Habitacion> findAll();
    Optional<Habitacion> findById(Long id);
    Habitacion save(Habitacion habitacion);
    void deleteById(Long id);
}
