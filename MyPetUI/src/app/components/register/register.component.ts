import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PetService} from "../../services/pet/pet.service";
import {Router} from "@angular/router";
import {Pet} from "../../models/pet";
import {Register} from "../../models/register";
import {PersonService} from "../../services/register/person.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  registerForm!:FormGroup;
  selectedImage!: String;
  constructor(
    private fb: FormBuilder,
    private personService: PersonService,
    private router: Router) {
    this.registerForm = this.fb.group({
      fullName:["",[Validators.required]],
      email:["",[Validators.required , Validators.email]],
      password:["",[Validators.required]],
      image:["",[Validators.required]],
      phoneNumber:["",[Validators.required]]
    })
  }


  onFileChange(event: any) {
    const reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event) => {
      if (reader.result) {
        this.selectedImage = reader.result.toString()
      }
    }
  }
  register(){
    const persom: Register = this.registerForm.value;
    this.registerForm.value.image = this.selectedImage;
    if (persom) {
      this.personService.register(persom).subscribe({
        next: (res)=>{
          console.log(res)
          alert(res.message)
        },
        error: (error)=>{
          console.log(error)

        }
      })}
  }
}
