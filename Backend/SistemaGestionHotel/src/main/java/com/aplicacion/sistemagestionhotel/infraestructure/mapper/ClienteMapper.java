package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.ClienteEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteEntity toEntity(Cliente cliente);
    Cliente toDomain(ClienteEntity clienteEntity);
    List<Cliente> toDomainList(List<ClienteEntity> clienteList);
}
