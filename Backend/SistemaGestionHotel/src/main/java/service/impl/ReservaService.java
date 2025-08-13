package service.impl;

import entity.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ReservaRepository;
import service.IReservaService;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ReservaService implements IReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }
}
