package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.application.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.domain.model.Reserva;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.ClienteEntity;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.ReservaEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaEntity toEntity(Reserva reserva);
    Reserva toDomain(ReservaEntity reservaEntity);
    List<Reserva> toDomainList(List<ReservaEntity> reservaList);

}
