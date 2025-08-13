package com.aplicacion.sistemagestionhotel.service;

import com.aplicacion.sistemagestionhotel.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.entity.Cliente;
import com.aplicacion.sistemagestionhotel.entity.Habitacion;
import com.aplicacion.sistemagestionhotel.entity.Reserva;

import java.util.Optional;

public interface IReservaConvertService {

    Cliente toCliente(ReservaClienteDTO dto);
    Reserva toReserva(ReservaClienteDTO dto, Cliente cliente,Habitacion habitacion);
}
