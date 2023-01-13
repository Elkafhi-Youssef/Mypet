 import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LoginComponent } from './login/login.component';
 import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AdoptionsComponent } from './adoptions/adoptions.component';
import { PageNotFoudComponent } from './page-not-foud/page-not-foud.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AddPetComponent } from './add-pet/add-pet.component';
 import {AppInterceptor} from "./interceptors/app-interceptor.interceptor";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdoptionsComponent,
    PageNotFoudComponent,
    NavBarComponent,
    AddPetComponent
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
