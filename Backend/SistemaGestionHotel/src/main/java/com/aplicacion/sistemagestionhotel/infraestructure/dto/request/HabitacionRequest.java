package com.aplicacion.sistemagestionhotel.infraestructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionRequest {

    @NotBlank(message = "El numero de habitacion no puede estar vacío")
    @Positive
    private int numero;

    @NotBlank(message = "El tipo de habitacion no puede estar vacío")
    private String tipo;

    @NotBlank(message = "EL precio de habitacion no puede estar vacío")
    @Positive
    private BigDecimal precioPorNoche;

    @NotNull(message = "El campo disponible no puede ser nulo")
    private boolean disponible;

    @NotBlank(message = "La capacidad de la habitacion no puede estar vacío")
    @Positive
    private int capacidad;

    @NotBlank(message = "La descripcion de la habitacion no puede estar vacío")
    private String Descripcion;

    @NotBlank(message = "La imagen url de la habitacion no puede estar vacío")
    private String imagenUrl;
}
