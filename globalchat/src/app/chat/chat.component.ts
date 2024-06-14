import { Component } from '@angular/core';
import { VistaSalasUsuarioComponent } from '../vista-salas-usuario/vista-salas-usuario.component';
import { VistaSalaComponent } from "../vista-sala/vista-sala.component";

@Component({
    selector: 'app-chat',
    standalone: true,
    templateUrl: './chat.component.html',
    styleUrl: './chat.component.css',
    imports: [VistaSalasUsuarioComponent, VistaSalaComponent]
})
export class ChatComponent {

}
