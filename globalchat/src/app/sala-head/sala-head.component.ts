import { Component } from '@angular/core';
import { ApiHttpService } from '../api.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'sala-head',
  standalone: true,
  imports: [],
  templateUrl: './sala-head.component.html',
  styleUrl: './sala-head.component.css'
})
export class SalaHeadComponent {
sala: any;
  constructor(apiService:ApiHttpService,cookieService:CookieService){
    this.sala=apiService.getSalaById(cookieService.get('sala_id'),cookieService.get('token')).subscribe({
      next:(sala) =>{
          this.sala= sala
      }
    })
  }
}
