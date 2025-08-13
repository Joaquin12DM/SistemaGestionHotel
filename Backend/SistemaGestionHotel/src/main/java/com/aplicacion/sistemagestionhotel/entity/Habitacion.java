package com.aplicacion.sistemagestionhotel.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "habitacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "tipo", length = 15, nullable = false)
    private String tipo;

    @Column(name = "precio_por_noche", nullable = false)
    private double precioPorNoche;

    @Column(name = "disponible", nullable = false)
    private boolean disponible;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    }
