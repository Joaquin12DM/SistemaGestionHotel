package com.aplicacion.sistemagestionhotel.infraestructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequest {

    @NotBlank(message = "El nombre del hotel no puede estar vacío")
    private String nombreHotel;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 200, message = "La dirección no puede superar los 200 caracteres")
    private String direccion;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(min = 9 , max = 9 , message = "El telefono debe tener 9 caracteres")
    @Pattern(regexp = "\\d", message = "El teléfono debe contener solo números")
    private String telefonoHotel;

    @NotBlank(message = "La URL de la imagen no puede estar vacía")
    private String imagenUrl;

}
