import { Injectable } from '@angular/core';
import {Register} from "../../models/register";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AppResponse} from "../../models/app-response";
import {Router} from "@angular/router";
import {LocalStorageService} from "../storage/local-storage.service";
import {env} from "../../../../config/env";
const url = env.url;
@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient,
              private router: Router,
              private localStorageService: LocalStorageService) { }

  register(person:Register){
    const headers = new HttpHeaders({
      'Content-Type':'application/json'
    });
    return this.http.post<AppResponse>(`${url}/persons/addPerson`,person, {headers});
  }
}
