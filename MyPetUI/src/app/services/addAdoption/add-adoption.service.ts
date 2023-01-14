import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {env} from "../../../../config/env";
import {AddAdoption} from "../../models/add-adoption";
import {AppResponse} from "../../models/app-response";
const url = env.url;
@Injectable({
  providedIn: 'root'
})
export class AddAdoptionService {

  constructor(private http: HttpClient) {

  }
  createAdoption(adoption: AddAdoption){
    const headers = new HttpHeaders({
      'Content-Type':'application/json'
    });
    return this.http.post<AppResponse>(`${url}/adoption`,adoption, {headers});
  }
}
