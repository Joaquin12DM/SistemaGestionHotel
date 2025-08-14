package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.HabitacionEntity;
import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface HabitacionMapper {

    HabitacionEntity toEntity(Habitacion habitacion);
    Habitacion toDomain(HabitacionEntity habitacionEntity);
    List<Habitacion> toDomainList(List<HabitacionEntity> habitacionList);
}
