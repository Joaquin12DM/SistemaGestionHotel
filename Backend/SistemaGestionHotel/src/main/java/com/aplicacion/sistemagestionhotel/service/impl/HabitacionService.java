package com.aplicacion.sistemagestionhotel.service.impl;


import com.aplicacion.sistemagestionhotel.entity.Habitacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aplicacion.sistemagestionhotel.repository.HabitacionRepository;
import com.aplicacion.sistemagestionhotel.service.IHabitacionService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HabitacionService implements IHabitacionService {

    private final HabitacionRepository habitacionRepository;

    @Override
    public List<Habitacion> findAll() {
        return habitacionRepository.findAll();
    }

    @Override
    public Optional<Habitacion> findById(Long id) {
        return habitacionRepository.findById(id);
    }

    @Override
    public Habitacion save(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    @Override
    public void deleteById(Long id) {
        habitacionRepository.deleteById(id);
    }

}
