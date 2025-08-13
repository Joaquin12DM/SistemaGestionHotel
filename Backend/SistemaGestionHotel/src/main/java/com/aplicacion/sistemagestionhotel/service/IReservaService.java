package com.aplicacion.sistemagestionhotel.service;

import com.aplicacion.sistemagestionhotel.entity.Reserva;

import java.util.List;
import java.util.Optional;

public interface IReservaService {

    List<Reserva> findAll();
    Optional<Reserva> findById(Long id);
    Reserva save(Reserva reserva);
    void deleteById(Long id);
}
