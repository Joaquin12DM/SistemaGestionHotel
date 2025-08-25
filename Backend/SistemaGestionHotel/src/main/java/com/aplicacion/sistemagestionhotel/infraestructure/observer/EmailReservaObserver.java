package com.aplicacion.sistemagestionhotel.infraestructure.observer;

import com.aplicacion.sistemagestionhotel.domain.model.Reserva;
import com.aplicacion.sistemagestionhotel.domain.observer.ReservaObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class EmailReservaObserver implements ReservaObserver {

    private final JavaMailSender mailSender;

    @Override
    public void reservaCreada(Reserva reserva) {
        long nochesReserva = java.time.temporal.ChronoUnit.DAYS.between(reserva.getFechaEntrada(), reserva.getFechaSalida());
        BigDecimal precioTotal = reserva.getHabitacion().getPrecioPorNoche().multiply(BigDecimal.valueOf(nochesReserva));

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(reserva.getCliente().getEmail());
        message.setSubject("Reserva realizada");
        message.setText("Su reserva ha sido realizada con éxito." +
                "\nDetalles de la reserva:" +
                "\nFecha de entrada: " + reserva.getFechaEntrada() +
                "\nFecha de salida: " + reserva.getFechaSalida() +
                "\nHabitación: " + reserva.getHabitacion().getNumero() +
                "\nPrecio total: S/" + precioTotal
        );
        mailSender.send(message);

    }
}
