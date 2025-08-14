package com.aplicacion.sistemagestionhotel.infraestructure.service.impl;

import com.aplicacion.sistemagestionhotel.application.dto.ReservaClienteDTO;
import com.aplicacion.sistemagestionhotel.domain.model.Cliente;
import com.aplicacion.sistemagestionhotel.domain.model.Habitacion;
import com.aplicacion.sistemagestionhotel.domain.model.Reserva;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.ClienteEntity;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.HabitacionEntity;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.ReservaEntity;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.ClienteMapper;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.HabitacionMapper;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.ReservaClienteMapper;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.ReservaMapper;
import com.aplicacion.sistemagestionhotel.infraestructure.repository.ClienteRepository;
import com.aplicacion.sistemagestionhotel.infraestructure.repository.HabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aplicacion.sistemagestionhotel.infraestructure.repository.ReservaRepository;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IReservaService;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ReservaService implements IReservaService {

    private final ReservaRepository reservaRepository;
    private final ReservaClienteMapper reservaClienteMapper;
    private final ReservaMapper reservaMapper;
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final HabitacionRepository habitacionRepository;
    private final HabitacionMapper habitacionMapper;

    @Override
    public List<Reserva> findAll() {
        return reservaMapper.toDomainList(reservaRepository.findAll());
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id)
                .map(reservaMapper::toDomain);
    }

    @Override
    public Reserva save(ReservaClienteDTO dto) {
        Cliente cliente = reservaClienteMapper.toCliente(dto);
        ClienteEntity entityCli = clienteMapper.toEntity(cliente);
        ClienteEntity savedCliente = clienteRepository.save(entityCli);
        Cliente saveCli = clienteMapper.toDomain(savedCliente);

        HabitacionEntity entityHab = habitacionRepository.findById(dto.getIdHabitacion())
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));

        Habitacion habitacion = habitacionMapper.toDomain(entityHab);
        ReservaEntity entityRe = reservaClienteMapper.toReserva(dto,saveCli,habitacion);

        ReservaEntity save = reservaRepository.save(entityRe);

        return reservaMapper.toDomain(save);
    }

    @Override
    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }
}
