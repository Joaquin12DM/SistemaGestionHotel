package service.impl;

import entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HotelRepository;
import service.IHotelService;

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
