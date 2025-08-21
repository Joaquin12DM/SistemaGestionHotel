package com.aplicacion.sistemagestionhotel.infraestructure.controller;

import com.aplicacion.sistemagestionhotel.application.Interfaces.IClienteService;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.ClienteRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.response.ClienteResponse;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.ClienteMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final IClienteService clienteService;
    private final ClienteMapper clienteMapper;

    @GetMapping
    public List<ClienteResponse> findAll() {
        return clienteMapper.toResponseList(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public Optional<ClienteResponse> findById(@PathVariable Long id) {
        return clienteService.findById(id)
                .map(clienteMapper::toResponse);
    }

    @PostMapping("/save")
    public ClienteResponse save(@RequestBody @Valid ClienteRequest clienteRequest) {
        var cliente = clienteMapper.toDomain(clienteRequest);
        return clienteMapper.toResponse(clienteService.save(cliente));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
    }

}
