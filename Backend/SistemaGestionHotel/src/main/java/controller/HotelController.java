package controller;

import entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.IHotelService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController(value = "/hotel")
public class HotelController {

    private final IHotelService hotelService;

    @GetMapping
    public List<Hotel> findAll() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Hotel> findById(@PathVariable Long id) {
        return hotelService.findById(id);
    }

    @PostMapping
    public Hotel save(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        hotelService.deleteById(id);
    }

}
