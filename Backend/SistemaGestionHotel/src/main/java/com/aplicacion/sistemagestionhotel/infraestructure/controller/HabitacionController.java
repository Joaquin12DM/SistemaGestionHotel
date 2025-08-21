package com.aplicacion.sistemagestionhotel.infraestructure.controller;

import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.HabitacionRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.response.HabitacionResponse;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.HabitacionMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IHabitacionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

    private final IHabitacionService habitacionService;
    private final HabitacionMapper habitacionMapper;

    @GetMapping
    public List<HabitacionResponse> findAll() {
        return habitacionMapper.toResponseList(habitacionService.findAll());
    }

    @GetMapping(value = "/filter", params = { "fechaEntrada", "fechaSalida" })
    public List<HabitacionResponse> findDisponiblesByFechas(
            @RequestParam("fechaEntrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaEntrada,
            @RequestParam("fechaSalida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaSalida) {

        return habitacionMapper.toResponseList(
                habitacionService.findDisponiblesByFechas(fechaEntrada, fechaSalida)
        );
    }

    @GetMapping("/{id}")
    public Optional<HabitacionResponse> findById(@PathVariable Long id) {
        return habitacionService.findById(id)
                .map(habitacionMapper::toResponse);
    }

    @GetMapping(params = "tipo")
    public List<HabitacionResponse> findByTipo(@RequestParam String tipo) {
        return habitacionMapper.toResponseList(habitacionService.findAllByTipo(tipo));
    }

    @PostMapping("/save")
    public HabitacionResponse save(@RequestBody @Valid HabitacionRequest habitacionRequest) {
        var habitacion = habitacionMapper.toDomain(habitacionRequest);
        return habitacionMapper.toResponse(habitacionService.save(habitacion));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        habitacionService.deleteById(id);
    }
}
