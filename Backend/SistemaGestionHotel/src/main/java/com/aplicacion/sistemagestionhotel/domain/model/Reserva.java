package com.aplicacion.sistemagestionhotel.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    private Long idReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;

    private Cliente cliente;
    private Habitacion habitacion;
}
