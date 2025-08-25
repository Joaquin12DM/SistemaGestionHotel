package com.aplicacion.sistemagestionhotel.domain.observer;

import com.aplicacion.sistemagestionhotel.domain.model.Reserva;

public interface ReservaObserver {

    void reservaCreada(Reserva reserva);
}
