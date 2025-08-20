import { Component, OnInit } from '@angular/core';
import { Habitacion, HabitacionService } from '../../../servicios/habitacion.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-habitaciones',
  templateUrl: './list_habitacion.html',
  imports: [CommonModule, RouterModule]
})
export class List_habitacion implements OnInit {
  habitaciones: Habitacion[] = [];
  cargando = true;
  error: string | null = null;

  constructor(private habitacionService: HabitacionService) {}

  ngOnInit(): void {
  this.obtenerHabitaciones();
}

obtenerHabitaciones(): void {
  this.habitacionService.getHabitaciones().subscribe({
    next: (data) => {
      console.log('Datos recibidos:', data);
      this.habitaciones = data;
      this.cargando = false;
    },
    error: (err) => {
      console.error('Error al listar habitaciones', err);
      this.error = 'No se cargó la lista de habitaciones';
      this.cargando = false;
    }
  });
}

  }

