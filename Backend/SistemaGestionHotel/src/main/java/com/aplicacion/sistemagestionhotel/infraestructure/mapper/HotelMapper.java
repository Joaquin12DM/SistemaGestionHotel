package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.domain.model.Hotel;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.HotelEntity;
import java.util.List;

import com.aplicacion.sistemagestionhotel.infraestructure.dto.request.HotelRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.response.HotelResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    Hotel toDomain(HotelRequest hotelRequest);
    HotelEntity toEntity(Hotel hotel);
    Hotel toDomain(HotelEntity hotelEntity);
    HotelResponse toResponse(Hotel hotel);
    List<Hotel> toDomainList(List<HotelEntity> hotelList);
    List<HotelResponse> toResponseList(List<Hotel> hotelList);

}
