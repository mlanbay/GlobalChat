import { Component } from '@angular/core';
import { ApiHttpService } from '../api.service';
import { CookieService } from 'ngx-cookie-service';
import { elementAt } from 'rxjs';

@Component({
  selector: 'check-topics-list',
  standalone: true,
  imports: [],
  templateUrl: './check-topics-list.component.html',
  styleUrl: './check-topics-list.component.css'
})
export class CheckTopicsListComponent {

constructor(private apiService:ApiHttpService,cookiesService:CookieService){
  const parser = new DOMParser();

  apiService.getAllTopicos(cookiesService.get("token")).subscribe({
    next:(data)=>{
      data.array.forEach((_topico: any) => {
        const elemento = document.getElementById("topicos")

        elemento?.appendChild(parser.parseFromString('<input type="checkbox" class="btn-check" autocomplete="off"><label class="btn">dfdf</label>', 'text/html'))

      });
    }
  })

}



}
