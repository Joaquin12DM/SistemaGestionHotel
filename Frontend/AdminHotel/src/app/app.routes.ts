import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login';
import { RegisterComponent } from './components/register/register';
import { DashboardComponent } from './components/dashboard/dashboard';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { 
    path: 'dashboard', 
    component: DashboardComponent,
    canActivate: [authGuard]  // Proteger la ruta del dashboard
  },
  // Puedes agregar más rutas protegidas aquí:
  // { 
  //   path: 'reservations', 
  //   component: ReservationsComponent, 
  //   canActivate: [authGuard] 
  // },
  // { 
  //   path: 'rooms', 
  //   component: RoomsComponent, 
  //   canActivate: [authGuard] 
  // },
  { path: '**', redirectTo: '/login' } // Ruta para manejar URLs no encontradas
];
