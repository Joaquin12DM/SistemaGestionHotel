package com.aplicacion.sistemagestionhotel.infraestructure.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @NotBlank(message = "El DNI no puede estar vacío")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
    @Pattern(regexp = "\\d+", message = "El DNI solo debe contener números")
    private String dni;

    @NotBlank(message = "El DNI no puede estar vacío")
    @Size(min = 9, max = 9, message = "El teléfono debe tener 9 caracteres")
    @Pattern(regexp = "\\d+", message = "El teléfono solo debe contener números")
    private String telefono;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe tener un formato válido")
    private String email;
}
