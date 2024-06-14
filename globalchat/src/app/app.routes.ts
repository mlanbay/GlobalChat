import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ChatComponent } from './chat/chat.component';

export const routes: Routes = [
    {
        path:"chat",
        component:ChatComponent
    },
    {
      path:"login",
      component:LoginComponent
    },
    {
      path:"signup",
      component:RegisterComponent
    }
];
