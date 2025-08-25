  import { CommonModule } from '@angular/common';
  import { Component, OnInit } from '@angular/core';
  import { RouterModule } from '@angular/router';
  import { Habitacion } from '../../servicios/habitacion.service';
  import { HabitacionService } from '../../servicios/habitacion.service';
  @Component({
    selector: 'app-home',
    standalone: true,
    imports: [RouterModule, CommonModule],
    templateUrl: './home.html',

  })
export class Home implements OnInit {
  habitaciones: Habitacion[] = [];
  cargando = true;
  error: string | null = null;

  constructor(private habitacionService: HabitacionService) {}

  ngOnInit(): void {
    this.habitacionService.getHabitaciones().subscribe({
      next: (data) => {
        this.habitaciones = data.slice(0, 8); // 🔹 Solo las primeras 8
        this.cargando = false;
      },
      error: (err) => {
        console.error('Error cargando habitaciones', err);
        this.error = 'No se pudieron cargar habitaciones populares';
        this.cargando = false;
      },
    });
  }
}