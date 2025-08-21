package com.aplicacion.sistemagestionhotel.infraestructure.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponse {

    private Long idHotel;
    private String nombreHotel;
    private String direccion;
    private String telefonoHotel;
    private String imagenUrl;
}
