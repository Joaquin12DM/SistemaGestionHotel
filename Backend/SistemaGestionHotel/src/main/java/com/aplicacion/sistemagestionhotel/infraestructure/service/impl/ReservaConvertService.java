package com.aplicacion.sistemagestionhotel.infraestructure.service.impl;

import com.aplicacion.sistemagestionhotel.application.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.domain.model.Reserva;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IReservaConvertService;
import org.springframework.stereotype.Service;

@Service
public class ReservaConvertService implements IReservaConvertService {


    @Override
    public Cliente toCliente(ReservaClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setDni(dto.getDni());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEmail(dto.getEmail());
        return cliente;
    }

    @Override
    public Reserva toReserva(ReservaClienteDTO dto, Cliente cliente, Habitacion habitacion) {
        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setHabitacion(habitacion);
        reserva.setFechaEntrada(dto.getFechaEntrada());
        reserva.setFechaSalida(dto.getFechaSalida());
        reserva.setEstado(dto.getEstado());
        return reserva;
    }


}
