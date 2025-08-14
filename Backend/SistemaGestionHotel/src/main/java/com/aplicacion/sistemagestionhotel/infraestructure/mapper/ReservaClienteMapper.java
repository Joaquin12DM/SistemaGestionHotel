package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.application.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.ReservaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaClienteMapper {

    Cliente toCliente(ReservaClienteDTO dto);
    ReservaEntity toReserva(ReservaClienteDTO dto, Cliente cliente, Habitacion habitacion);
    ReservaClienteDTO toReservaDTO(ReservaEntity reserva);

}
