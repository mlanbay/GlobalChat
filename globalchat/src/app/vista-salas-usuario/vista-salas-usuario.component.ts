import { Component } from '@angular/core';
import { ProfileLabelComponent } from '../profile-label/profile-label.component';
import { SalasUsuarioListComponent } from '../salas-usuario-list/salas-usuario-list.component';

@Component({
  selector: 'vista-salas-usuario',
  standalone: true,
  imports: [ProfileLabelComponent,SalasUsuarioListComponent],
  template: `
    <profile-label  class="p-3 row"></profile-label>
    <div class="row background-aqua">s</div>
    <salas-usuario-list class="row background-chat justify-content-center"></salas-usuario-list>
  `,
  styleUrl: './vista-salas-usuario.component.css'
})
export class VistaSalasUsuarioComponent {

}
