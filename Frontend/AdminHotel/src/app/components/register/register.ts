import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './register.html',
  styleUrls: ['./register.css']
})
export class RegisterComponent {
  registerData = { username: '', password: '', nombre: '', apellido: '' };
  registerError: string = '';
  isLoading: boolean = false;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  onRegister() {
    // Validación manual
    if (!this.registerData.username || !this.registerData.password || 
        !this.registerData.nombre || !this.registerData.apellido) {
      this.registerError = 'Por favor completa todos los campos';
      return;
    }
    
    this.isLoading = true;
    this.registerError = '';

    this.authService.register(this.registerData).subscribe({
      next: (res) => {
        this.isLoading = false;
        // Aquí podrías redirigir al login o mostrar un mensaje de éxito
        alert('Registro exitoso. Por favor inicia sesión.');
        // Redireccionar al login usando Router
        this.router.navigate(['/login']);
      },
      error: (err) => {
        this.isLoading = false;
        console.error('Error en registro:', err);
        this.registerError = err?.error?.message || 'Error en el registro. Por favor intenta nuevamente.';
      }
    });
  }
}
