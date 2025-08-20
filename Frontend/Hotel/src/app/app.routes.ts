import { Routes } from '@angular/router';
import { Home } from './component/paguinas/home/home';
import { Hotel } from './component/paguinas/hotel/hotel';

export const routes: Routes = [

    {path: "", component: Home},
    {path: 'Hotel' , component: Hotel}
    
];
