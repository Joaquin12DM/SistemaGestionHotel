package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.domain.model.Reserva;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.ReservaEntity;
import java.util.List;

import com.aplicacion.sistemagestionhotel.infraestructure.dto.response.ReservaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaEntity toEntity(Reserva reserva);
    Reserva toDomain(ReservaEntity reservaEntity);
    List<Reserva> toDomainList(List<ReservaEntity> reservaList);
    List<ReservaResponse> toResponseList(List<Reserva> reservaList);

    @Mapping(source = "cliente.nombre", target = "nombre")
    @Mapping(source = "cliente.apellido", target = "apellido")
    @Mapping(source = "cliente.dni", target = "dni")
    @Mapping(source = "cliente.telefono", target = "telefono")
    @Mapping(source = "cliente.email", target = "email")
    @Mapping(source = "habitacion.idHabitacion", target = "idHabitacion")
    ReservaResponse toResponse(Reserva reserva);

}
