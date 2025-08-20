import { Routes } from '@angular/router';
import { List_habitacion } from './component/habitacion/listar_habitacion/list_habitacion';
import { Home } from './component/home/home';
import { FechaReserva } from './component/reserva/fecha-reserva/fecha-reserva';

export const routes: Routes = [

    {path: "", component: Home},
    {path: "habitaciones", component: List_habitacion},
    {path: "fecha-reserva", component: FechaReserva}
    
];
