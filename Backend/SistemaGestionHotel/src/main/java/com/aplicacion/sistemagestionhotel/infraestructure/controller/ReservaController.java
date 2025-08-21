package com.aplicacion.sistemagestionhotel.infraestructure.controller;

import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.ReservaRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.response.ReservaResponse;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.ReservaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IReservaService;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")

@RequiredArgsConstructor
@RestController
@RequestMapping("/reserva")
public class ReservaController {

    private final IReservaService reservaService;
    private final ReservaMapper reservaMapper;

    @GetMapping
    public List<ReservaResponse> findAll() {
        return reservaMapper.toResponseList(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public Optional<ReservaResponse> findById(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(reservaMapper::toResponse);
    }


    @PostMapping("/save")
    public ReservaResponse save(@RequestBody @Valid ReservaRequest dto) {
        return reservaMapper.toResponse(reservaService.save(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reservaService.deleteById(id);
    }


}
