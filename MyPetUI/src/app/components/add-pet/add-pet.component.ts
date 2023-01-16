import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth/auth.service";
import {PetService} from "../../services/pet/pet.service";
import {Router} from "@angular/router";
import {Pet} from "../../models/pet";
import {AppResponse} from "../../models/app-response";
import {AddAdoption} from "../../models/add-adoption";

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent {
  form!:FormGroup;
  selectedImage!: String;
  constructor(
    private fb: FormBuilder,
    private petService: PetService,
    private router: Router) {
    this.form = this.fb.group({
      petname:["",[Validators.required]],
      age:["",[Validators.required]],
      type:["",[Validators.required]],
      image:["",[Validators.required]]
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
  addpet(){

    const pet: Pet = this.form.value;
    this.form.value.image = this.selectedImage;

    // console.log(formData.get('age'))
    console.log(this.form.value.image);
    if (pet) {
    this.petService.createPet(pet).subscribe({
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
