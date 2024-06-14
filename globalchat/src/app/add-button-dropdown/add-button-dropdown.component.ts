import { Component } from '@angular/core';
import { ModalCrearSalaComponent } from '../modal-crear-sala/modal-crear-sala.component';
import { ModalListarSalasComponent } from '../modal-listar-salas/modal-listar-salas.component';

@Component({
  selector: 'add-button-dropdown',
  standalone: true,
  imports: [ModalCrearSalaComponent, ModalListarSalasComponent],
  templateUrl: './add-button-dropdown.component.html',
  styleUrl: './add-button-dropdown.component.css'
})
export class AddButtonDropdownComponent {

}
