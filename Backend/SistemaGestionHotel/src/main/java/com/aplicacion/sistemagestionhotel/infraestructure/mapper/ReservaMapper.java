package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.domain.model.Reserva;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.ReservaEntity;
import java.util.List;

import com.aplicacion.sistemagestionhotel.infraestructure.dto.response.ReservaResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaEntity toEntity(Reserva reserva);
    Reserva toDomain(ReservaEntity reservaEntity);
    List<Reserva> toDomainList(List<ReservaEntity> reservaList);
    List<ReservaResponse> toResponseList(List<Reserva> reservaList);
    ReservaResponse toResponse(Reserva reserva);

}
