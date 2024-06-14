import { Component } from '@angular/core';
import { CheckTopicsListComponent } from "../check-topics-list/check-topics-list.component";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgForm } from '@angular/forms';
import { ApiHttpService } from '../api.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
    selector: 'form-crear-sala-privada',
    standalone: true,
    templateUrl: './form-crear-sala-privada.component.html',
    styleUrl: './form-crear-sala-privada.component.css',
    imports: [CheckTopicsListComponent,FormsModule,CommonModule]
})
export class FormCrearSalaPrivadaComponent {


  constructor(private apiService:ApiHttpService,private cookieService:CookieService){}

  isFormSubmited:boolean = false;

  crearSalaPrivada:any={
    nombre:"",
    descripcion:"",
    password:""
  }
  onSubmit(crearSalaPrivadaForm: NgForm) {
    this.isFormSubmited = true;
    const isValid = crearSalaPrivadaForm.form.valid
    if(isValid){
      this.apiService.crearSalaPrivada(this.crearSalaPrivada.nombre,this.crearSalaPrivada.descripcion,this.crearSalaPrivada.password,[],this.cookieService.get('usuario_id'),this.cookieService.get('token')).subscribe({
        next:()=>{
          
        }
      })
    }
  
  }
}
