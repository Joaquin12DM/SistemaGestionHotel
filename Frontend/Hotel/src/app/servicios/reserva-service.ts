import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export interface ReservaCliente {
  clienteId : number; 
  nombre: string;
  apellido: string;
  dni: string;   
  telefono?: string;
  email?: string;

  fechaEntrada: string; // "YYYY-MM-DD"
  fechaSalida: string;  // "YYYY-MM-DD"
  estado?: string;

  idHabitacion: number; 
}

@Injectable({
    providedIn: "root"
})
export class ReservaService{
    private apiUrl = "http://localhost:8082/reserva"

    constructor(private http: HttpClient){}

    //Guardar cliente nuevo.
    saveReserva(ReservaCliente: any): Observable<any> {
        return this.http.post(`${this.apiUrl}/save`, ReservaCliente)
    }
}
