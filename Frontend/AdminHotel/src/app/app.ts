import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Header } from "./layout/header/header";
import { Footer } from "./layout/footer/footer";
import { Subscription } from 'rxjs';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, Header, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})  
export class App implements OnInit, OnDestroy {
  protected readonly title = 'AdminHotel';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  //ocultar header/footer
  isLoginRoute(): boolean {
    return this.router.url === '/login';
  }

  ngOnInit(): void {

  }

  // llamado desde <app-header (logout)="onLogout()">
  onLogout(): void {
    try {
      if (typeof (this.authService as any).logout === 'function') {
        (this.authService as any).logout();
      } else {
        localStorage.removeItem('auth_token');
        localStorage.removeItem('auth_user');
      }
    } finally {
      this.router.navigate(['/login']);
    }
  }

  ngOnDestroy(): void {

  }
}
