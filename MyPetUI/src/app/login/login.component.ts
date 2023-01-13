import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthService} from "../services/auth/auth.service";
import {LocalStorageService} from "../services/storage/local-storage.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  form!:FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private localStorageService: LocalStorageService,
    private router: Router){
    this.form = this.fb.group({
      email: "",
      password: ""
    });
  }

  login(){
    const values = this.form.value;

    if(values.email && values.password){
      this.authService.login(values.email,values.password).subscribe(
        (res) => {
          console.log(res)
          if(res.status == 200){
            this.localStorageService.set("token",res.token);
            this.router.navigateByUrl('/adoptions');
          }else{
            this.router.navigateByUrl('/login');
          }
        }
      )
    }

  }

}
