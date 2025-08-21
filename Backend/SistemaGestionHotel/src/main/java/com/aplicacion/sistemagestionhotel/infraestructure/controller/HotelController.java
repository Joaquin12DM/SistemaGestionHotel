package com.aplicacion.sistemagestionhotel.infraestructure.controller;

import com.aplicacion.sistemagestionhotel.domain.model.Hotel;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.HotelRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.response.HotelResponse;
import com.aplicacion.sistemagestionhotel.infraestructure.mapper.HotelMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.aplicacion.sistemagestionhotel.application.Interfaces.IHotelService;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final IHotelService hotelService;
    private final HotelMapper hotelMapper;

    @GetMapping
    public List<HotelResponse> findAll() {
        return hotelMapper.toResponseList(hotelService.findAll());
    }

    @GetMapping("/{id}")
    public Optional<HotelResponse> findById(@PathVariable Long id) {
        return hotelService.findById(id)
                .map(hotelMapper::toResponse);
    }

    @PostMapping("/save")
    public HotelResponse save(@RequestBody @Valid HotelRequest hotelDTO) {
        Hotel hotel = hotelMapper.toDomain(hotelDTO);
        return hotelMapper.toResponse(hotelService.save(hotel));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        hotelService.deleteById(id);
    }

}
