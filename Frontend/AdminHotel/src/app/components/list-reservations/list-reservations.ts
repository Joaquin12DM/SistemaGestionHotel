import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../models/reserva.model';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ReservaService } from '../../services/reserva.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-list-reservations',
  imports: [CommonModule, RouterModule],
  templateUrl: './list-reservations.html',
  styleUrl: './list-reservations.css'
})
export class ListReservations implements OnInit {
  reservas: Reserva[] = [];
  cargando = false;
  error = '';
  // sort control: true = asc, false = desc
  sortAsc = true;

  constructor(private reservaService: ReservaService) {}

  ngOnInit(): void {
    this.loadReservas();
  }

  loadReservas(): void {
  this.cargando = true;
  this.error = '';
  this.reservaService.getReservas().subscribe({
    next: (data) => {
      this.reservas = (data || []).map(r => ({
        ...r,
        estado: r.estado?.toUpperCase()  
      }));
      this.sortByFechaEntrada(this.sortAsc);
      this.cargando = false;
    },
    error: (err: HttpErrorResponse) => {
      console.error('Error al cargar reservas', err);
      this.error = err.error?.message || 'No se pudieron cargar las reservaciones';
      this.cargando = false;
    }
  });
}

  sortByFechaEntrada(asc: boolean): void {
    this.sortAsc = asc;
    this.reservas.sort((a, b) => {
      //Date ('YYYY-MM-DD')
      const da = a.fechaEntrada ? new Date(a.fechaEntrada) : new Date(0);
      const db = b.fechaEntrada ? new Date(b.fechaEntrada) : new Date(0);
      return asc ? da.getTime() - db.getTime() : db.getTime() - da.getTime();
    });
  }

  toggleSort(): void {
    this.sortByFechaEntrada(!this.sortAsc);
  }

  deleteReserva(id?: number): void {
    if (!id) return;
    if (!confirm('¿Eliminar reserva? Esta acción no se puede deshacer.')) return;
    this.reservaService.deleteReserva(id).subscribe({
      next: () => {

        this.reservas = this.reservas.filter(r => r.id !== id);
      },
      error: (err: HttpErrorResponse) => {
        console.error('Error al eliminar reserva', err);
        alert(err.error?.message || 'No se pudo eliminar la reserva');
      }
    });
  }
}