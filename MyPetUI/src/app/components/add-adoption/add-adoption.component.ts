import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AddAdoption} from "../../models/add-adoption";
import {AddAdoptionService} from "../../services/addAdoption/add-adoption.service";

@Component({
  selector: 'app-add-adoption',
  templateUrl: './add-adoption.component.html',
  styleUrls: ['./add-adoption.component.css']
})
export class AddAdoptionComponent {
  form!:FormGroup;
  constructor(
    private fb: FormBuilder,
    private addAdoptionService: AddAdoptionService,
    private router: Router) {
    this.form = this.fb.group({
      description:"",
      city:"",
      numberDays:"",
      price:"",
      petId:""
    })
  }
  addAdoption(){
    const adoption: AddAdoption = this.form.value;
    console.log(adoption);
    if(adoption){
      this.addAdoptionService.createAdoption(adoption).subscribe({
        next: (res)=>{
          console.log(res)
          alert(res.message)
        },
        error: (error)=>{
          console.log(error)
          // alert(error.error.message)
        }
      })
    }


  }

}
