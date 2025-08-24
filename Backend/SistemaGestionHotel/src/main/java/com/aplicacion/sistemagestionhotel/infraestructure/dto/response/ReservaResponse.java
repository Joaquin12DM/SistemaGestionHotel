package com.aplicacion.sistemagestionhotel.infraestructure.dto.response;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaResponse {


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
