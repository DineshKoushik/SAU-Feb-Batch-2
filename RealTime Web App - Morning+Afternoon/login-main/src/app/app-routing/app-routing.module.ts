import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';
import { HomeComponent } from '../home/home.component';

const appRouts : Routes = [
  {
    path:'',
    component: LoginComponent,
  },
  {
    path:'signup',
    component: SignupComponent,
  },
  {
    path:'home',
    component:HomeComponent,
  }
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(appRouts)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
