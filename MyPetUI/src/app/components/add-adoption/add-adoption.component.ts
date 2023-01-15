import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AddAdoption} from "../../models/add-adoption";
import {AddAdoptionService} from "../../services/addAdoption/add-adoption.service";
import {PetForAdoption} from "../../models/pet-for-adoption";
import {PetService} from "../../services/pet/pet.service";

@Component({
  selector: 'app-add-adoption',
  templateUrl: './add-adoption.component.html',
  styleUrls: ['./add-adoption.component.css']
})
export class AddAdoptionComponent implements OnInit{
  form!:FormGroup;
  petOfPersonConnected!:PetForAdoption[]

  constructor(
    private fb: FormBuilder,
    private addAdoptionService: AddAdoptionService,
    private petService: PetService,
    private router: Router) {
    this.form = this.fb.group({
      description:"",
      city:"",
      numberDays:"",
      price:"",
      petId:""
    })
  }

  ngOnInit() {
    this.petService.getPetsListForAdoption().subscribe({
      next: (res)=>{
        this.petOfPersonConnected = res.data;
        console.log(res.data)
      },
      error: (error)=>{
        alert(error.error.message)
      }
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
