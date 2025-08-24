import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { TokenService } from './token.service';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private apiUrl = 'http://localhost:8082/auth';

  constructor(
    private http: HttpClient,
    private tokenService: TokenService
  ) {}

  register(data: { username: string; password: string; nombre: string; apellido: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, data);
  }

  login(data: { username: string; password: string }): Observable<any> {
    return this.http.post<{token: string, username: string}>(`${this.apiUrl}/login`, data)
      .pipe(
        tap(response => {
          if (response && response.token) {
            this.tokenService.saveToken(response.token);
            this.tokenService.saveUser({
              username: response.username,
              // Puedes guardar más datos del usuario si el backend te los envía
            });
          }
        })
      );
  }

  logout(): void {
    this.tokenService.clear();
  }

  isLoggedIn(): boolean {
    return this.tokenService.isAuthenticated();
  }

  getCurrentUser(): any {
    return this.tokenService.getUser();
  }
}
