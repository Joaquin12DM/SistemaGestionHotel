package controller;

import entity.Habitacion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import repository.HabitacionRepository;
import service.IHabitacionService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController(value = "/habitacion")
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

    @PostMapping
    public Habitacion save(@RequestBody Habitacion habitacion) {
        return habitacionService.save(habitacion);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        habitacionService.deleteById(id);
    }
}
