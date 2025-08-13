package com.aplicacion.sistemagestionhotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaClienteDTO {

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;

    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String estado;

    private Long idHabitacion;
}
