package com.aplicacion.sistemagestionhotel.infraestructure.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionResponse {

    private Long idHabitacion;
    private int numero;
    private String tipo;
    private BigDecimal precioPorNoche;
    private boolean disponible;
    private int capacidad;
    private String Descripcion;
    private String imagenUrl;

}
