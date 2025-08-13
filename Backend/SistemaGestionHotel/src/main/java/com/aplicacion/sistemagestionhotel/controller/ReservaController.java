package com.aplicacion.sistemagestionhotel.controller;

import com.aplicacion.sistemagestionhotel.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.entity.Reserva;
import com.aplicacion.sistemagestionhotel.service.IClienteService;
import com.aplicacion.sistemagestionhotel.service.IHabitacionService;
import com.aplicacion.sistemagestionhotel.service.IReservaConvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.aplicacion.sistemagestionhotel.service.IReservaService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reserva")
public class ReservaController {

    private final IReservaService reservaService;
    private final IReservaConvertService  reservaConvertService;
    private final IClienteService clienteService;
    private final IHabitacionService habitacionService;

    @GetMapping
    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> findById(@PathVariable Long id) {
        return reservaService.findById(id);
    }

    @PostMapping("/save")
    public Reserva save(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PostMapping("/saveReserva")
    public Reserva save(@RequestBody ReservaClienteDTO dto) {
        var cliente = reservaConvertService.toCliente(dto);
        cliente = clienteService.save(cliente);

        var habitacion = habitacionService.findById(dto.getIdHabitacion())
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));

        var reserva = reservaConvertService.toReserva(dto,cliente,habitacion);

        return reservaService.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reservaService.deleteById(id);
    }


}
