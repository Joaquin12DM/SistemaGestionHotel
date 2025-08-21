import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Habitacion {
  idHabitacion: number;
  numero: number;
  tipo: string;
  precioPorNoche: number;
  descripcion: string;
  capacidad: number;
  imagenUrl: string;
} 

@Injectable({ providedIn: 'root' })
export class HabitacionService {
  private apiUrl = 'http://localhost:8082/habitacion';

  constructor(private http: HttpClient) {}

  getHabitaciones(): Observable<Habitacion[]> {
    return this.http.get<Habitacion[]>(this.apiUrl);
  }

  getDisponibles(fechaEntrada: string, fechaSalida: string): Observable<Habitacion[]> {
    return this.http.get<Habitacion[]>(
      `${this.apiUrl}/filter?fechaEntrada=${fechaEntrada}&fechaSalida=${fechaSalida}`
    ); 
}

getById(id: number): Observable<Habitacion> {
    return this.http.get<Habitacion>(`${this.apiUrl}/${id}`);
  }
}
