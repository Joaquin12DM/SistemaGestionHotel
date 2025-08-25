import { Routes } from '@angular/router';
import { List_habitacion } from './component/habitacion/listar_habitacion/list_habitacion';
import { Home } from './component/home/home';
import { ReservaHabitacion } from './component/habitacion/reserva-habitacion/reserva-habitacion';

import { Contact } from './component/contact/contact';
import { About } from './component/about/about';
import { Privacy } from './component/layout/privacy/privacy';
import { Terms } from './component/layout/terms/terms';

export const routes: Routes = [

    {path: "", component: Home},
    {path: "habitaciones", component: List_habitacion},
    { path: 'reservar/:id', component: ReservaHabitacion},


    { path: 'contacto', component: Contact},
    { path: 'about', component:About },
    { path: 'privacy', component:Privacy},
    { path: 'terms', component:Terms}
    
];
