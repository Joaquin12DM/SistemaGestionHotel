import { Routes } from '@angular/router';
import { List_habitacion } from './component/habitacion/listar_habitacion/list_habitacion';
import { Home } from './component/home/home';
import { ReservaHabitacion } from './component/habitacion/reserva-habitacion/reserva-habitacion';
import { Login } from './component/login/login';
import { Contact } from './component/contact/contact';
import { About } from './component/about/about';

export const routes: Routes = [

    {path: "", component: Home},
    {path: "habitaciones", component: List_habitacion},
    //nuevo:
    { path: 'reservar/:id', component: ReservaHabitacion},
    { path: 'login', component: Login},
    { path: 'contacto', component: Contact},
    { path: 'about', component:About }
    
];
