import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MyPetUI';
  onKeyUp(){
    console.log(this.email)
  }

  xxx = ["vvv","hhhh"]
  email:String  = "you@gmail.com"

}
