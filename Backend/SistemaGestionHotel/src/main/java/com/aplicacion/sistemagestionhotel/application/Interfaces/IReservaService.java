package com.aplicacion.sistemagestionhotel.application.Interfaces;

import com.aplicacion.sistemagestionhotel.application.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.domain.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface IReservaService {

    List<Reserva> findAll();
    Optional<Reserva> findById(Long id);
    Reserva save(ReservaClienteDTO dto);
    void deleteById(Long id);
}
