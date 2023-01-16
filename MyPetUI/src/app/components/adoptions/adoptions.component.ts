import {Component, OnInit} from '@angular/core';
import {AddAdoptionService} from "../../services/addAdoption/add-adoption.service";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {Addoptions} from "../../models/addoptions";
import {of} from "rxjs";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PetService} from "../../services/pet/pet.service";
import {Router} from "@angular/router";
import {Pet} from "../../models/pet";
import {Accepted} from "../../models/accepted";

@Component({
  selector: 'app-adoptions',
  templateUrl: './adoptions.component.html',
  styleUrls: ['./adoptions.component.css']
})
export class AdoptionsComponent implements OnInit{
addoptions!:Addoptions[];
  accepted!:FormGroup
  constructor(
    private fb: FormBuilder,
    private addAdoptionService: AddAdoptionService,
    private router: Router) {
    this.accepted = this.fb.group({
      id:["",[Validators.required]],
    })
  }

  ngOnInit(): void {
  this.addAdoptionService.getAllFreeAdoptions().subscribe({
    next:(res)=>{
      this.addoptions = res.data
      console.log(res.data)
      this.addoptions.forEach(function(element) {
        console.log(element.person.fullName);
      });
    },
    error:(error)=>{
      console.log("error")
    }
  })
  }
  reloadAdoptions(){
    this.addAdoptionService.getAllFreeAdoptions().subscribe({
      next:(res)=>{
        this.addoptions = res.data
        console.log(res.data)
        this.addoptions.forEach(function(element) {
          console.log(element.person.fullName);
        });
      },
      error:(error)=>{
        console.log("error")
      }
    })
  }
  onaccepted(){
    const id: Accepted = this.accepted.value;
    console.log(id)
    if (id) {
      this.addAdoptionService.accepted(id).subscribe({
        next: (res)=>{
          console.log(res.data)
          alert(res.message)
          this.reloadAdoptions();
        },
        error: (error)=>{


        }
      })}
  }

}
