import { Component, OnInit } from '@angular/core';
import { Habitacion, HabitacionService } from '../../../servicios/habitacion.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-habitaciones',
  templateUrl: './list_habitacion.html',
  imports: [CommonModule, RouterModule, FormsModule]
})
export class List_habitacion implements OnInit {
  habitaciones: Habitacion[] = [];
  cargando = true;
  error: string | null = null;
  // Parametros del filtro
  mostrarFiltros = false;
  fechaEntrada: string ="";
  fechaSalida: string="";





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

filtrarHabitaciones(): void {
    if (!this.fechaEntrada || !this.fechaSalida) {
      this.error = 'Debe seleccionar ambas fechas';
      return;
    }
    this.cargando = true;
    this.error = null;
    this.habitacionService.getDisponibles(this.fechaEntrada, this.fechaSalida).subscribe({
      next: (data) => {
        console.log('Habitaciones disponibles:', data);
        this.habitaciones = data;
        this.cargando = false;
      },
      error: (err) => {
        console.error('Error al filtrar habitaciones', err);
        this.error = 'No se pudo obtener las habitaciones disponibles';
        this.cargando = false;
      }
    });
  }

  }

