package controller;

import entity.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.IReservaService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController(value="/reserva")
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

    @PostMapping
    public Reserva save(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reservaService.deleteById(id);
    }


}
