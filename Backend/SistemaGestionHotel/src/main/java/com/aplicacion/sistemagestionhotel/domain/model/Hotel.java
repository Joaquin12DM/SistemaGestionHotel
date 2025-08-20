package com.aplicacion.sistemagestionhotel.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private Long idHotel;
    private String nombreHotel;
    private String direccion;
    private String telefonoHotel;
    private String imagenUrl;

}
