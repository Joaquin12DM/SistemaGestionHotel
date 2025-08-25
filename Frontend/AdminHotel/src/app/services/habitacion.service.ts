import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Habitacion } from '../models/habitacion.model';

@Injectable({
  providedIn: 'root'
})
export class HabitacionService {
  private baseUrl = 'http://localhost:8082/habitacion';

  constructor(private http: HttpClient) {}

  getAllHabitaciones(): Observable<Habitacion[]> {
    return this.http.get<Habitacion[]>(this.baseUrl);
  }

  // obtiene habitaciones disponibles para una fecha (YYYY-MM-DD)
  getDisponiblesByFecha(fechaIso: string): Observable<Habitacion[]> {
    const params = new HttpParams().set('fecha', fechaIso);
    return this.http.get<Habitacion[]>(this.baseUrl, { params });
  }

  getHabitacionById(id: number) {
    return this.http.get<Habitacion>(`${this.baseUrl}/${id}`);
  }

  deleteHabitacion(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

 
  getByTipo(tipo: string) {
    const params = new HttpParams().set('tipo', tipo);
    return this.http.get<Habitacion[]>(this.baseUrl, { params });
  }
}