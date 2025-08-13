package service;

import entity.Habitacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IHabitacionService {

    List<Habitacion> findAll();
    Optional<Habitacion> findById(Long id);
    Habitacion save(Habitacion habitacion);
    void deleteById(Long id);
}
