package com.aplicacion.sistemagestionhotel.infraestructure.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Long idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
}
