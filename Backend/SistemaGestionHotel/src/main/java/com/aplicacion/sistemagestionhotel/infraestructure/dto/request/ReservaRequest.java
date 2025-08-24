package com.aplicacion.sistemagestionhotel.infraestructure.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @NotBlank(message = "El DNI no puede estar vacío")
    @Size(min = 8, max = 8, message = "El DNI debe contar con 8 caracteres")
    @Pattern(regexp = "\\d{0,8}", message = "El DNI debe contener solo números")
    private String dni;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(min = 9, max = 9, message = "El telefono debe contar con 9 caracteres")
    @Pattern(regexp = "\\d{0,9}", message = "El teléfono debe contener solo números")
    private String telefono;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotNull(message = "La fecha de entrada no puede ser nula")
    private LocalDate fechaEntrada;

    @NotNull(message = "La fecha de salida no puede ser nula")
    private LocalDate fechaSalida;

    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;

    @NotNull(message = "El id de la habitación no puede ser nulo")
    private Long idHabitacion;

}
