package com.aplicacion.sistemagestionhotel.infraestructure.controller;

import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IHabitacionService;

import java.time.LocalDate;
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

    @GetMapping(params = "fecha",name = "/filter")
    public List<Habitacion> findByFecha(@RequestParam("fecha")LocalDate fecha){
        return habitacionService.findDisponiblesByFecha(fecha);
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
