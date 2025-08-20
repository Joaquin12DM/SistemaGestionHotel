package com.aplicacion.sistemagestionhotel.application.Interfaces;


import com.aplicacion.sistemagestionhotel.domain.model.Reserva;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.ReservaRequest;

import java.util.List;
import java.util.Optional;

public interface IReservaService {

    List<Reserva> findAll();
    Optional<Reserva> findById(Long id);
    Reserva save(ReservaRequest dto);
    void deleteById(Long id);
}
