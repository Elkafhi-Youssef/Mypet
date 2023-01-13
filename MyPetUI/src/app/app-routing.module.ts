import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// @ts-ignore
import {AdoptionsComponent} from './adoptions/adoptions.component'
import {LoginComponent} from './login/login.component'
import  {PageNotFoudComponent} from './page-not-foud/page-not-foud.component'
import {AddPetComponent} from './add-pet/add-pet.component'

const routes: Routes = [
  {path: "adoptions", component: AdoptionsComponent},
  {path: "login", component: LoginComponent},
  {path: "addPet", component: AddPetComponent},
  {path: "**", component: PageNotFoudComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

