import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {LocalStorageService} from "../storage/local-storage.service";
import {Pet} from "../../models/pet";
import {AppResponse} from "../../models/app-response";
import {env} from "../../../../config/env";
const url = env.url;
@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private http: HttpClient,
              private router: Router,
              private localStorageService: LocalStorageService) { }
  createOffer(pet: Pet){
    const headers = new HttpHeaders({
      'Content-Type':'application/json'
    });
    return this.http.post<AppResponse>(`${url}/pet`,pet, {headers});
  }
}
