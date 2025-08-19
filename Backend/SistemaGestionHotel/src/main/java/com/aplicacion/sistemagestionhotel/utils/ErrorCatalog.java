package com.aplicacion.sistemagestionhotel.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    RESERVA_NOT_FOUND("RES-404", "Reserva no encontrada"),
    CLIENTE_NOT_FOUND("CLI-404", "Cliente no encontrado"),
    HOTEL_NOT_FOUND("HOT-404", "Hotel no encontrado"),
    HABITACION_NOT_FOUND("HAB-404", "Habitación no encontrada"),
    INVALID_RESERVA("RES-400", "Datos de reserva inválidos"),
    INVALID_CLIENTE("CLI-400", "Datos de cliente inválidos"),
    INVALID_HOTEL("HOT-400", "Datos de hotel inválidos"),
    INVALID_HABITACION("HAB-400", "Datos de habitación inválidos"),
    GENERIC_ERROR("GEN-500", "Error interno del servidor");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
