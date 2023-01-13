import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthService} from "../services/auth/auth.service";
import {PetService} from "../services/pet/pet.service";
import {Router} from "@angular/router";
import {Pet} from "../models/pet";

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent {
  form!:FormGroup;

  constructor(
    private fb: FormBuilder,
    private petService: PetService,
    private router: Router) {
    this.form = this.fb.group({
      petname:"",
      age:"",
      type:"",
      images:""
    })
  }
  addpet(){
    const pet: Pet = this.form.value;
    console.log(pet);
    if(pet){
      this.petService.createOffer(pet).subscribe({
        next: (res)=>{
          console.log(res)
          alert(res.message)
        },
        error: (error)=>{
          console.log(error)
          alert(error.error.message)
        }
      })
    }


  }

}
