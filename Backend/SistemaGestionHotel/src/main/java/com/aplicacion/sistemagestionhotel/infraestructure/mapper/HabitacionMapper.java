package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.HabitacionEntity;
import java.util.List;

import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.HabitacionRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.response.HabitacionResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface HabitacionMapper {

    Habitacion toDomain(HabitacionRequest habitacionRequest);
    HabitacionEntity toEntity(Habitacion habitacion);
    Habitacion toDomain(HabitacionEntity habitacionEntity);
    HabitacionResponse toResponse(Habitacion habitacion);
    List<Habitacion> toDomainList(List<HabitacionEntity> habitacionList);
    List<HabitacionResponse>  toResponseList(List<Habitacion> habitacionList);
}
