package com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Long idHotel;
    @Column(name= "nombre_hotel",length = 50,nullable = false)
    private String nombreHotel;

    @Column(name= "direccion",length = 30)
    private String direccion;

    @Column(name= "telefono_hotel",length = 20)
    private String telefonoHotel;

    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<HabitacionEntity> habitaciones;

}
