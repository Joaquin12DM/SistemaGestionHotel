package com.aplicacion.sistemagestionhotel.service.impl;

import com.aplicacion.sistemagestionhotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aplicacion.sistemagestionhotel.repository.HotelRepository;
import com.aplicacion.sistemagestionhotel.service.IHotelService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService implements IHotelService {

    private final  HotelRepository hotelRepository;

    public List<Hotel>  findAll() {
        return  hotelRepository.findAll();
    }

    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id);
    }

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteById(Long id) {
         hotelRepository.deleteById(id);
    }



}
