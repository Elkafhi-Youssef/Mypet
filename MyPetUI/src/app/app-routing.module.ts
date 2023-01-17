import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// @ts-ignore
import {AdoptionsComponent} from './components/adoptions/adoptions.component'
import {LoginComponent} from './components/login/login.component'
import  {PageNotFoudComponent} from './components/page-not-foud/page-not-foud.component'
import {AddPetComponent} from './components/add-pet/add-pet.component'
import { AddAdoptionComponent } from './components/add-adoption/add-adoption.component';
import {RegisterComponent}  from "./components/register/register.component";

const routes: Routes = [
  {path: "adoptions", component: AdoptionsComponent},
  {path: "login", component: LoginComponent},
  {path: "addPet", component: AddPetComponent},
  {path: "addAdoption", component: AddAdoptionComponent},
  {path: "register", component: RegisterComponent},
  {path: "**", component: PageNotFoudComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

