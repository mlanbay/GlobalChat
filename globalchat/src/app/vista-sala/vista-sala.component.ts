import { Component } from '@angular/core';
import { SalaHeadComponent } from "../sala-head/sala-head.component";
import { SalaChatViewComponent } from "../sala-chat-view/sala-chat-view.component";
import { MessageInputComponent } from "../message-input/message-input.component";

@Component({
    selector: 'vista-sala',
    standalone: true,
    template: `
                <sala-head></sala-head>
                <sala-chat-view></sala-chat-view>
                <message-input></message-input>`,
    styleUrl: './vista-sala.component.css',
    imports: [SalaHeadComponent, SalaChatViewComponent, MessageInputComponent]
})
export class VistaSalaComponent {

}
