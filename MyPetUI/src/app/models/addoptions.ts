import {Pet} from "./pet";

interface Person {
  fullName: string;
}
export interface Addoptions {
  id:number;
  description: String;
  city: String;
  numberDays : String;
  price:String;

  person:Person;
  pet:Pet;

}
