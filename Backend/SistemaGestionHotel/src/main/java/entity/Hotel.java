package entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private int idHotel;
    @Column(name= "nombre_hotel",length = 50,nullable = false)
    private String nombreHotel;

    @Column(name= "direccion",length = 30)
    private String direccion;

    @Column(name= "telefono_hotel",length = 20)
    private String telefonoHotel;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habitacion> habitaciones;

}
