package com.aplicacion.sistemagestionhotel.infraestructure.service.impl;

import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.ClienteEntity;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aplicacion.sistemagestionhotel.infraestructure.repository.ClienteRepository;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IClienteService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public List<Cliente> findAll() {
        return clienteMapper.toDomainList(clienteRepository.findAll());
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toDomain);
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity entity = clienteMapper.toEntity(cliente);
        ClienteEntity save = clienteRepository.save(entity);
        return clienteMapper.toDomain(save);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

}
