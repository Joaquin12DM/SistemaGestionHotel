import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login';
import { RegisterComponent } from './components/register/register';
import { DashboardComponent } from './components/dashboard/dashboard';
import { authGuard } from './guards/auth.guard';
import { Habitaciones } from './components/room/habitaciones';
import { Reservations } from './components/reservations/reservations';
import { ReporteReservas } from './components/reporte-reservas/reporte-reservas';
import { ListReservations } from './components/list-reservations/list-reservations';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { 
    path: 'dashboard', 
    component: DashboardComponent,
    canActivate: [authGuard]  // Proteger la ruta del dashboard
  },

  {path: 'rooms', component: Habitaciones},
    {path: 'reservations', component: Reservations},
    {path: 'reporteReservas', component: ReporteReservas},
    {path: 'listReservas', component: ListReservations},
  { path: '**', redirectTo: '/login' } 
];
