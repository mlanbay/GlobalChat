import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormCrearSalaPublicaComponent } from '../form-crear-sala-publica/form-crear-sala-publica.component';
import { FormCrearSalaPrivadaComponent } from '../form-crear-sala-privada/form-crear-sala-privada.component';

@Component({
  selector: 'modal-crear-sala',
  standalone: true,
  imports: [CommonModule, FormCrearSalaPublicaComponent, FormCrearSalaPrivadaComponent],
  templateUrl: './modal-crear-sala.component.html',
  styleUrls: ['./modal-crear-sala.component.css']
})
export class ModalCrearSalaComponent {
  public showPublica: boolean = true;

  ShowFormCrearSalaPublica() {
    this.showPublica = true;
    console.log("Sala Publica seleccionada");
  }

  ShowFormCrearSalaPrivada() {
    this.showPublica = false;
    console.log("Sala Privada seleccionada");
  }
}
