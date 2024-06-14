import { Component } from '@angular/core';
import { CheckTopicsListComponent } from "../check-topics-list/check-topics-list.component";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgForm } from '@angular/forms';
import { ApiHttpService } from '../api.service';
import { CookieService } from 'ngx-cookie-service';
import { tick } from '@angular/core/testing';
@Component({
    selector: 'form-crear-sala-publica',
    standalone: true,
    templateUrl: './form-crear-sala-publica.component.html',
    styleUrl: './form-crear-sala-publica.component.css',
    imports: [CheckTopicsListComponent,FormsModule,CommonModule]
})
export class FormCrearSalaPublicaComponent {
  constructor(private apiService:ApiHttpService,private cookieService:CookieService){}

  isFormSubmited:boolean = false;

  crearSalaPublica:any={
    nombre:"",
    descripcion:"",
  }

  onSubmit(crearSalaPublicaForm:NgForm){
    this.isFormSubmited=true;
    const isValid = crearSalaPublicaForm.form.valid;

    if(isValid){
      this.apiService.crearSalaPublica(this.crearSalaPublica.nombre,this.crearSalaPublica.descripcion,[],this.cookieService.get("usuario_id"),this.cookieService.get('token')).subscribe({
        next:()=>{

        }
      })
    }


  }

}
