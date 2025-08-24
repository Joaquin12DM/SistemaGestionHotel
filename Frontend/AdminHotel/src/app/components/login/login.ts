
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class LoginComponent {
  loginData = { username: '', password: '' };
  loginError: string = '';
  isLoading: boolean = false;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  onLogin() {
    // Validación manual
    if (!this.loginData.username || !this.loginData.password) {
      this.loginError = 'Por favor ingresa tu usuario y contraseña';
      return;
    }
    
    this.isLoading = true;
    this.loginError = '';
    
    this.authService.login(this.loginData).subscribe({
      next: (res) => {
        // Login exitoso, el token ya se guarda en el servicio
        console.log('Login exitoso');
        this.isLoading = false;
        
        // Redirigir al dashboard o página principal
        this.router.navigate(['/dashboard']);
      },
      error: (err) => {
        this.isLoading = false;
        console.error('Error en login:', err);
        this.loginError = err?.error?.message || 'Usuario o contraseña incorrectos';
      }
    });
  }
}
