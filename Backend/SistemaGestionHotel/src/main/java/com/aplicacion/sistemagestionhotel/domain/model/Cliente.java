package com.aplicacion.sistemagestionhotel.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Long idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
}
