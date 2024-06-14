import { Component } from '@angular/core';
import { ChangeThemeButtonComponent } from '../change-theme-button/change-theme-button.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgForm } from '@angular/forms';
import { ApiHttpService } from '../api.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  standalone: true,
  imports: [ChangeThemeButtonComponent,FormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  isFormSubmited:boolean = false;

  userLogin:any = {
    email:"",
    password:""
  }

  constructor(private apiService:ApiHttpService, private cookieService:CookieService,private router:Router){

  }

  onSubmit(loginForm:NgForm){
    this.isFormSubmited=true;
    const isValid = loginForm.form.valid;

    if(isValid){

      this.apiService.loginUser(this.userLogin.email,this.userLogin.password).subscribe({
        next:(data) => {
          this.cookieService.set("usuario_id",data['id'])
        //  this.cookieService.set("refresh_token",data['refresh_token'])

          // this.apiService.getUsuarioByEmail(this.userLogin.email,"").subscribe({
          //   next:(usuario)=>{
          //     const usuario_id=usuario['usuario_id']
          //     this.cookieService.set("usuario_id",usuario_id)

          //   }
          // })

          this.router.navigate(['/chat']);
        },
        error:() => {
          //this.cookieService.set("token","");
          //this.cookieService.set("refresh_token","")
          this.cookieService.set("usuario_id","")
        }
      })

      

    }

  }

}
