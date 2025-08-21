import { Routes } from '@angular/router';
import { List_habitacion } from './component/habitacion/listar_habitacion/list_habitacion';
import { Home } from './component/home/home';

export const routes: Routes = [

    {path: "", component: Home},
    {path: "habitaciones", component: List_habitacion},
    
];
