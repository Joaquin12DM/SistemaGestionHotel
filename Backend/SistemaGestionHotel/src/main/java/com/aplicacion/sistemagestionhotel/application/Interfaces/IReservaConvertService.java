package com.aplicacion.sistemagestionhotel.application.Interfaces;

import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.domain.model.Reserva;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.ReservaRequest;


public interface IReservaConvertService {

    Cliente toCliente(ReservaRequest dto);
    Reserva toReserva(ReservaRequest dto, Cliente cliente, Habitacion habitacion);
}
