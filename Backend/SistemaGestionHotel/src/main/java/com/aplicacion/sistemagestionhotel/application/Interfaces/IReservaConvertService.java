package com.aplicacion.sistemagestionhotel.application.Interfaces;

import com.aplicacion.sistemagestionhotel.application.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.domain.model.Reserva;


public interface IReservaConvertService {

    Cliente toCliente(ReservaClienteDTO dto);
    Reserva toReserva(ReservaClienteDTO dto, Cliente cliente, Habitacion habitacion);
}
