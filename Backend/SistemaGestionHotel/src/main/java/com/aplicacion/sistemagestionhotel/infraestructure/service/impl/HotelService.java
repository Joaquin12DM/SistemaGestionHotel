package com.aplicacion.sistemagestionhotel.infraestructure.service.impl;

import com.aplicacion.sistemagestionhotel.domain.model.Hotel;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.HotelEntity;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aplicacion.sistemagestionhotel.infraestructure.repository.HotelRepository;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IHotelService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService implements IHotelService {

    private final  HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public List<Hotel>  findAll() {
        return hotelMapper.toDomainList(hotelRepository.findAll());
    }

    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id)
                .map(hotelMapper::toDomain);
    }

    public Hotel save(Hotel hotel) {
        HotelEntity entity = hotelMapper.toEntity(hotel);
        HotelEntity save = hotelRepository.save(entity);
        return hotelMapper.toDomain(save);
    }

    public void deleteById(Long id) {
         hotelRepository.deleteById(id);
    }

}
