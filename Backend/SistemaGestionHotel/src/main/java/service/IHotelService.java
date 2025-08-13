package service;

import entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface IHotelService {

    List<Hotel> findAll();

     Optional<Hotel> findById(Long id);

     Hotel save(Hotel hotel);

     void deleteById(Long id);
}
