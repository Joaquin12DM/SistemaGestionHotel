import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

export interface Hotel {
    idhotel :number;
    imagenUrl : string;
}

@Injectable ({providedIn: "root"})
export class HotelService {
    private apiUrl = 'http://localhost:8082/hotel'

    constructor(private http: HttpClient){}
    getHotel(): Observable<Hotel[]>{
        return this.http.get<Hotel[]>(this.apiUrl)
    }
}