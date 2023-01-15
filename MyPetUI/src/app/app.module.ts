 import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LoginComponent } from './components/login/login.component';
 import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AdoptionsComponent } from './components/adoptions/adoptions.component';
import { PageNotFoudComponent } from './components/page-not-foud/page-not-foud.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { AddPetComponent } from './components/add-pet/add-pet.component';
 import {AppInterceptor} from "./interceptors/app-interceptor.interceptor";
import { AddAdoptionComponent } from './components/add-adoption/add-adoption.component';
import { ContainerComponent } from './components/container/container.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdoptionsComponent,
    PageNotFoudComponent,
    NavBarComponent,
    AddPetComponent,
    AddAdoptionComponent,
    ContainerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AppInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
