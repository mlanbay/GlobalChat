import { Component } from '@angular/core';
import { ApiHttpService } from '../api.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'profile-label',
  standalone: true,
  imports: [],
  templateUrl: './profile-label.component.html',
  styleUrl: './profile-label.component.css'
})
export class ProfileLabelComponent {
  username!: string;

  constructor(apiService:ApiHttpService,cookieService:CookieService){
    apiService.getUsuarioById(cookieService.get('usuario_id'),cookieService.get('token')).subscribe({
      next:(usuario)=>{
       this.username= usuario['username']
      }
    })
  }

}
