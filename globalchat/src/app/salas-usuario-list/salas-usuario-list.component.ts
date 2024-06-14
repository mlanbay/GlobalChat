import { Component } from '@angular/core';
import { AddButtonDropdownComponent } from '../add-button-dropdown/add-button-dropdown.component';
import { ChangeThemeButtonComponent } from '../change-theme-button/change-theme-button.component';
import { SalaItemComponent } from '../sala-item/sala-item.component';

@Component({
  selector: 'salas-usuario-list',
  standalone: true,
  imports: [AddButtonDropdownComponent,ChangeThemeButtonComponent,SalaItemComponent],
  template: `
    <sala-item></sala-item>
    <add-button-dropdown></add-button-dropdown>
    <change-theme-button></change-theme-button>
  `,
  styleUrl: './salas-usuario-list.component.css'
})
export class SalasUsuarioListComponent {

}
