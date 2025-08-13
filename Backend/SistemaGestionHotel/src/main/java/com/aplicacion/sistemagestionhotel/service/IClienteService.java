package com.aplicacion.sistemagestionhotel.service;

import com.aplicacion.sistemagestionhotel.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);

}
