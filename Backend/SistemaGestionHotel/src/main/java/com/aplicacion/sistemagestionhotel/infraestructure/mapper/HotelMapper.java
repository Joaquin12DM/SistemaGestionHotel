package com.aplicacion.sistemagestionhotel.infraestructure.mapper;

import com.aplicacion.sistemagestionhotel.domain.model.Hotel;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity.HotelEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelEntity toEntity(Hotel hotel);
    Hotel toDomain(HotelEntity hotelEntity);
    List<Hotel> toDomainList(List<HotelEntity> hotelList);
}
