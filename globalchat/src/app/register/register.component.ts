import { Component } from '@angular/core';
import { ChangeThemeButtonComponent } from '../change-theme-button/change-theme-button.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgForm } from '@angular/forms';
import { ApiHttpService } from '../api.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'register',
  standalone: true,
  imports: [ChangeThemeButtonComponent, FormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  isFormSubmited: boolean = false;
  userRegister: any = {
    email: "",
    nombre: "",
    apellido: "",
    password: "",
    confirmPassword: ""
  }



  constructor(private apiService: ApiHttpService, private cookieService: CookieService, private router: Router) { }

  onSubmit(registerForm: NgForm) {
    this.isFormSubmited = true;
    const isValid = registerForm.form.valid;

    if (isValid) {
     // this.apiService.registerFirebaseRequest(this.userRegister.email, this.userRegister.password).subscribe({
      //  next: (data) => {
          this.apiService.registerUser(this.userRegister.email, this.userRegister.username, this.userRegister.nombre, this.userRegister.apellidos, this.userRegister.password).subscribe({
            next: (usuario) => {
              // this.cookieService.set("token", usuario['idToken'])
              // this.cookieService.set("refresh_token", usuario['refresh_token'])
              this.cookieService.set('usuario_id',usuario['usuario_id'])
              this.router.navigate(['/chat'])
            },
            error: (err) => {
              // this.cookieService.set("token", "")
              // this.cookieService.set("refresh_token", "")
              this.cookieService.set('usuario_id',"")
            }
          })
      //  },
      //  error: (err) => {
      //    this.cookieService.set("token", "")
      //    this.cookieService.set("refresh_token", "")
      //  }
    //  })
    }

  }

}
