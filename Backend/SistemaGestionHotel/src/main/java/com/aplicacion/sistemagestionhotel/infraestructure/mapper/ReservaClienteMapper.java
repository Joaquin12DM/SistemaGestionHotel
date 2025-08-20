package com.aplicacion.sistemagestionhotel.infraestructure.mapper;


import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.ReservaEntity;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.ReservaRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaClienteMapper {

    Cliente toCliente(ReservaRequest dto);
    ReservaEntity toReserva(ReservaRequest dto, Cliente cliente, Habitacion habitacion);

}
