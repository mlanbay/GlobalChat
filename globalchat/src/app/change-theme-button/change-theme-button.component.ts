import { Component } from '@angular/core';

@Component({
  selector: 'change-theme-button',
  standalone: true,
  imports: [],
  templateUrl: './change-theme-button.component.html',
  styleUrl: './change-theme-button.component.css'
})
export class ChangeThemeButtonComponent {
  cambiarTema(){
    document.body.classList.toggle("dark-theme")
  }
}
