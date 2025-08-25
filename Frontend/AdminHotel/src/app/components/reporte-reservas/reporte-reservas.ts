import { Component } from '@angular/core';
import { ReportesService } from '../../services/reporte-service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-reporte-reservas',
  imports: [CommonModule, FormsModule],
  templateUrl: './reporte-reservas.html',
  styleUrl: './reporte-reservas.css'
})
export class ReporteReservas {
  mes: number = new Date().getMonth() + 1; // mes actual
  anio: number = new Date().getFullYear(); // año actual
  anios: number[] = [2023, 2024, 2025, 2026];
  numeroReservas: number | null = null;
  sumaMonto: number | null = null;
  promedioPorReserva: number | null = null;

  // comparación con consulta anterior
  reservasPrevias: number | null = null;
  montoPrevio: number | null = null;
  variacionReservas: number | null = null;
  variacionMonto: number | null = null;

  loading = false;
  errorMsg = '';

  constructor(private reportesService: ReportesService) {}

  consultarReporte() {
    this.loading = true;
    this.errorMsg = '';

    this.reportesService.getNumeroReservasPorMes(this.mes, this.anio).subscribe({
      next: (num) => {
        this.numeroReservas = num;
        this.reportesService.getSumaMontoPorMes(this.mes, this.anio).subscribe({
          next: (suma) => {
            this.sumaMonto = suma;

            // cálculo local del promedio
            if (this.numeroReservas && this.numeroReservas > 0) {
              this.promedioPorReserva = this.sumaMonto! / this.numeroReservas;
            } else {
              this.promedioPorReserva = null;
            }

            // comparación con la consulta anterior
            if (this.reservasPrevias !== null && this.montoPrevio !== null) {
              this.variacionReservas = this.calcularVariacion(this.reservasPrevias, this.numeroReservas!);
              this.variacionMonto = this.calcularVariacion(this.montoPrevio, this.sumaMonto!);
            }

            // actualizar "último" 
            this.reservasPrevias = this.numeroReservas;
            this.montoPrevio = this.sumaMonto;

            this.loading = false;
          },
          error: () => {
            this.errorMsg = 'Error obteniendo monto total';
            this.loading = false;
          }
        });
      },
      error: () => {
        this.errorMsg = 'Error obteniendo número de reservas';
        this.loading = false;
      }
    });
  }

  private calcularVariacion(previo: number, actual: number): number {
    if (previo === 0) return 100; // evitar división entre cero
    return ((actual - previo) / previo) * 100;
  }
}