package entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "habitacion")
@Data
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

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;
    }
