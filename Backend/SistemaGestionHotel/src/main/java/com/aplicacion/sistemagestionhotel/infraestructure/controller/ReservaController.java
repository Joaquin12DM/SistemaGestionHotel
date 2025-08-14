package com.aplicacion.sistemagestionhotel.infraestructure.controller;

import com.aplicacion.sistemagestionhotel.application.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.domain.model.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IReservaService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reserva")
public class ReservaController {

    private final IReservaService reservaService;

    @GetMapping
    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> findById(@PathVariable Long id) {
        return reservaService.findById(id);
    }


    @PostMapping("/save")
    public Reserva save(@RequestBody ReservaClienteDTO dto) {
        return reservaService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reservaService.deleteById(id);
    }


}
