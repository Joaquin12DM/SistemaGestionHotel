import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { ReservaService } from '../../services/reserva.service';
import { Reserva } from '../../models/reserva.model';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule, DatePipe],
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css']
})
export class DashboardComponent implements OnInit {
  currentUser: any = null;
  reservas: Reserva[] = [];
  cargandoReservas = false;
  errorReservas = '';
  
  constructor(
    private authService: AuthService,
    private reservaService: ReservaService
  ) {}

  ngOnInit(): void {
    this.currentUser = this.authService.getCurrentUser();
    this.cargarReservas();
  }
  
  cargarReservas(): void {
    this.cargandoReservas = true;
    this.reservaService.getReservas().subscribe({
      next: (data) => {
        this.reservas = (data || []).slice().reverse();
        this.cargandoReservas = false;
      },
      error: (error) => {
        console.error('Error al cargar reservas:', error);
        this.errorReservas = 'No se pudieron cargar las reservaciones';
        this.cargandoReservas = false;
      }
    });
  }

  logout(): void {
    this.authService.logout();
    window.location.href = '/login'; 
  }
}
