  import { Component, OnInit } from '@angular/core';
  import { RouterModule } from '@angular/router';
  import { CommonModule } from '@angular/common';
import { Hotel, HotelService } from '../../servicios/hotel.service';
import { Habitacion, HabitacionService } from '../../servicios/habitacion.service';

  @Component({
    selector: 'app-home',
    standalone: true,
    imports: [RouterModule, CommonModule],
    templateUrl: './home.html',

  })
  export class Home implements OnInit {
    Hotel: Hotel | null = null;
    Habitacion: Habitacion[] = [];
    cargando = true;
    error: string | null = null;

    constructor(private hotel: HotelService, private habitacionService: HabitacionService ){}
    

    ngOnInit(): void {
      this.obtenerHotel();
      this.obtenerHabitaciones();
    }

    

    obtenerHotel(): void {
    this.hotel.getHotel().subscribe({
    next: (data) => {
      console.log('Datos de Hotel:', data);  
      this.Hotel = data.length > 0 ? data[0] : null;
      this.cargando = false;
    },
    error: (err) => {
      console.error('Error cargando hotel:', err); 
      this.error = 'No se cargó hotel';
      this.cargando = false;
    }
    });
    }

    obtenerHabitaciones(): void {
      this.habitacionService.getHabitaciones().subscribe({
        next: (data) => {
       console.log('Datos recibidos:', data);
       this.Habitacion = this.HabitacionesRandom(data, 5);
        this.cargando = false;
    },
    error: (err) => {
      console.error('Error al listar habitaciones', err);
      this.error = 'No se cargó la lista de habitaciones';
      this.cargando = false;
    }
    });
  }

  private HabitacionesRandom (lista: Habitacion[], cantidad: number): Habitacion[] {
      return lista
      .sort(()=> 0.5 - Math.random())
      .slice(0, cantidad);
    }



}
