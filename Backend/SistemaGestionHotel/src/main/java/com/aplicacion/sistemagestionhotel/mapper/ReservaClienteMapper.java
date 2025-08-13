package com.aplicacion.sistemagestionhotel.mapper;

import com.aplicacion.sistemagestionhotel.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.entity.Cliente;
import com.aplicacion.sistemagestionhotel.entity.Habitacion;
import com.aplicacion.sistemagestionhotel.entity.Hotel;
import com.aplicacion.sistemagestionhotel.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ReservaClienteMapper {

    @Mapping(target = "idCliente", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Cliente toCliente(ReservaClienteDTO dto);

    @Mapping(target = "idReserva", ignore = true)
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "habitacion", target = "habitacion")
    Reserva toReserva(ReservaClienteDTO dto, Cliente cliente, Habitacion habitacion);

}
