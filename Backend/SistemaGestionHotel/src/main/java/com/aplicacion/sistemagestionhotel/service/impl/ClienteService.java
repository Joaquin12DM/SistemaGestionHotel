package com.aplicacion.sistemagestionhotel.service.impl;

import com.aplicacion.sistemagestionhotel.entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aplicacion.sistemagestionhotel.repository.ClienteRepository;
import com.aplicacion.sistemagestionhotel.service.IClienteService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final  ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

}
