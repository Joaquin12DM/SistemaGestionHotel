import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-header',
  imports: [CommonModule, RouterModule],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {
 @Input() currentUser: any = null;
  @Output() logout = new EventEmitter<void>();

  // controla el menu en mobile
  menuOpen = false;

  // items del menú (centrales)
  menuItems = [
    { label: 'Dashboard', link: '/dashboard' },
    { label: 'Todas las reservas', link: '/listReservas' },
    { label: 'Crear reserva', link: '/reservations' },
    { label: 'Habitaciones', link: '/rooms' },
    { label: 'Reporte', link: '/reporteReservas' },
  ];

  toggleMenu() { this.menuOpen = !this.menuOpen; }
  onLogout() { this.logout.emit(); }
}