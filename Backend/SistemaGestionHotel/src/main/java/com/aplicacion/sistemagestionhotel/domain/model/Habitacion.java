package com.aplicacion.sistemagestionhotel.domain.model;

import java.math.BigDecimal;

import com.aplicacion.sistemagestionhotel.domain.enums.EstadoHabitacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {

    private Long idHabitacion;
    private int numero;
    private String tipo;
    private BigDecimal precioPorNoche;
    private boolean disponible;
    private int capacidad;
    private String imagenUrl;
}
