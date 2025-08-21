package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.ClienteEntity;
import java.util.List;

import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.ClienteRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.response.ClienteResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toDomain(ClienteRequest clienteRequest);
    ClienteEntity toEntity(Cliente cliente);
    Cliente toDomain(ClienteEntity clienteEntity);
    ClienteResponse toResponse(Cliente cliente);
    List<Cliente> toDomainList(List<ClienteEntity> clienteList);
    List<ClienteResponse> toResponseList(List<Cliente> clienteList);
}
