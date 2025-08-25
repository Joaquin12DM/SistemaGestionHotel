import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class  ReportesService {
  private apiUrl = 'http://localhost:8082/reserva'; 

  constructor(private http: HttpClient) {}

  getNumeroReservasPorMes(mes: number, anio: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/reservas-por-mes?mes=${mes}&anio=${anio}`);
  }

  getSumaMontoPorMes(mes: number, anio: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/suma-monto-por-mes?mes=${mes}&anio=${anio}`);
  }
}