package com.aplicacion.sistemagestionhotel.controller;

import com.aplicacion.sistemagestionhotel.entity.Habitacion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.aplicacion.sistemagestionhotel.service.IHabitacionService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

    private final IHabitacionService habitacionService;

    @GetMapping
    public List<Habitacion> findAll() {
        return habitacionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Habitacion> findById(@PathVariable Long id) {
        return habitacionService.findById(id);
    }

    @PostMapping("/save")
    public Habitacion save(@RequestBody Habitacion habitacion) {
        return habitacionService.save(habitacion);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        habitacionService.deleteById(id);
    }
}
