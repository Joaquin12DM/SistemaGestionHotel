package com.aplicacion.sistemagestionhotel.infraestructure.service.impl;


import com.aplicacion.sistemagestionhotel.domain.enums.EstadoHabitacion;
import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.HabitacionEntity;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.HabitacionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aplicacion.sistemagestionhotel.infraestructure.repository.HabitacionRepository;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IHabitacionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HabitacionService implements IHabitacionService {

    private final HabitacionRepository habitacionRepository;
    private final HabitacionMapper habitacionMapper;

    @Override
    public List<Habitacion> findAll() {
        return habitacionMapper.toDomainList(habitacionRepository.findAll());
    }

    @Override
    public Optional<Habitacion> findById(Long id) {
        return habitacionRepository.findById(id)
                .map(habitacionMapper::toDomain);
    }

    @Override
    public Habitacion save(Habitacion habitacion) {
        HabitacionEntity entity = habitacionMapper.toEntity(habitacion);
        HabitacionEntity save = habitacionRepository.save(entity);
        return habitacionMapper.toDomain(save);
    }

    @Override
    public void deleteById(Long id) {
        habitacionRepository.deleteById(id);
    }

    @Override
    public List<Habitacion> findDisponiblesByFecha(LocalDate fecha) {
        List<HabitacionEntity> disponibles = habitacionRepository.findDisponiblesByFecha(fecha);
        return habitacionMapper.toDomainList(disponibles);
    }

}
