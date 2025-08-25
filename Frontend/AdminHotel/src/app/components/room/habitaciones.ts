import { CommonModule, DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Habitacion } from '../../models/habitacion.model';
import { HabitacionService } from '../../services/habitacion.service';

@Component({
  selector: 'app-habitaciones',
  imports: [CommonModule, RouterModule],
  templateUrl: './habitaciones.html',
  styleUrl: './habitaciones.css'
})
export class Habitaciones implements OnInit {
  
  allHabitaciones: Habitacion[] = [];
  habitaciones: Habitacion[] = [];
  disponiblesHoy: Habitacion[] = [];
  mostrarTodas = false;
  cargando = false;
  error = '';

  // estadisticas
  total = 0;
  disponiblesCount = 0;
  ocupadasCount = 0;
  porTipo: Record<string, { total: number; disponibles: number }> = {};

  constructor(
    private habitacionService: HabitacionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadData();
  }

  private formatHoyIso(): string {
    const hoy = new Date();
    return hoy.toISOString().split('T')[0]; // YYYY-MM-DD
  }

  loadData(): void {
    this.cargando = true;
    this.error = '';

    const fechaHoy = this.formatHoyIso();

    this.habitacionService.getAllHabitaciones().subscribe({
      next: (all) => {
        this.allHabitaciones = all;
        this.total = all.length;
        this.computePorTipo(all);

        this.habitacionService.getDisponiblesByFecha(fechaHoy).subscribe({
          next: (disp) => {
            this.disponiblesHoy = disp;
            this.disponiblesCount = disp.length;
            this.ocupadasCount = this.total - this.disponiblesCount;
            this.computeDisponiblesPorTipo();
            this.applyFilter(); 
            this.cargando = false;
          },
          error: (err) => {
            console.error('Error al obtener disponibles:', err);
            this.error = 'No se pudieron cargar las habitaciones disponibles';
            this.cargando = false;
          }
        });
      },
      error: (err) => {
        console.error('Error al obtener habitaciones:', err);
        this.error = 'No se pudieron cargar las habitaciones';
        this.cargando = false;
      }
    });
  }

  private computePorTipo(all: Habitacion[]) {
    this.porTipo = {};
    all.forEach(h => {
      const tipo = h.tipo ?? 'OTRO';
      if (!this.porTipo[tipo]) this.porTipo[tipo] = { total: 0, disponibles: 0 };
      this.porTipo[tipo].total++;
    });
  }

  private computeDisponiblesPorTipo() {
    Object.keys(this.porTipo).forEach(k => this.porTipo[k].disponibles = 0);
    this.disponiblesHoy.forEach(h => {
      const tipo = h.tipo ?? 'OTRO';
      if (!this.porTipo[tipo]) this.porTipo[tipo] = { total: 0, disponibles: 0 };
      this.porTipo[tipo].disponibles++;
    });
  }

  toggleMostrarTodas(): void {
    this.mostrarTodas = !this.mostrarTodas;
    this.applyFilter();
  }

  applyFilter(): void {
    // baseamos en allHabitaciones (inmutable) para no perder datos
    if (this.mostrarTodas) {
      this.habitaciones = [...this.allHabitaciones];
    } else {
      const ids = new Set(this.disponiblesHoy.map(h => h.idHabitacion));
      this.habitaciones = this.allHabitaciones.filter(h => ids.has(h.idHabitacion));
    }
  }

  estadoDe(h: Habitacion): string {
    if (!h.disponible) return 'Mantenimiento';
    const isDisp = this.disponiblesHoy.some(d => d.idHabitacion === h.idHabitacion);
    return isDisp ? 'Disponible' : 'Ocupada';
  }

  deleteHabitacion(h: Habitacion) {
    if (!h.idHabitacion) return;
    if (!confirm(`¿Eliminar habitación ${h.numero}?`)) return;
    this.habitacionService.deleteHabitacion(h.idHabitacion).subscribe({
      next: () => this.loadData(),
      error: (err) => {
        console.error('Error al eliminar habitación:', err);
        alert('No se pudo eliminar la habitación');
      }
    });
  }

  // stub para edición: navega a ruta /rooms/edit/:id 
  editHabitacion(h: Habitacion) {
    if (!h.idHabitacion) return;
    this.router.navigate(['/rooms', 'edit', h.idHabitacion]);
  }
}