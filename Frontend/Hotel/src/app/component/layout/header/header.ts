import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Home } from '../../paguinas/home/home';
import { Hotel } from '../../paguinas/hotel/hotel';

@Component({
  selector: 'app-header',
  imports: [RouterModule, Home, Hotel],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {

}
