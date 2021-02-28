import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomDateService} from '../CustomDatePipe/date.service';

class employee{
  fname:string;
  lname:string;
  number:number;
  dob:Date;
  city:string;
  pin:number;
  constructor(fname:string,lname:string,number:number,dob:Date,city:string,pin:number){
  this.fname=fname;
  this.lname=lname;
  this.number=number;
  this.dob=dob;
  this.city=city;
  this.pin=pin;
  }
  
  }

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {


  details: employee[] = [];

  constructor() { }

  ngOnInit(): void {
  }
  loginForm = new FormGroup({
    fname : new FormControl('',Validators.required),
    lname : new FormControl(''),
    number : new FormControl('',Validators.required),
    dob : new FormControl(''),
    city : new FormControl(''),
    pin : new FormControl('')
  })

  get number(){return this.loginForm.get('number')}
  get fname(){return this.loginForm.get('fname')}



  OnSubmit = () => {
    const values = this.loginForm.value;
    const record : employee = {
      fname : values.fname,
      lname : values.lname,
      number : values.number, 
      dob : values.dob,
      city : values.city,
      pin : values.pin,
    };

    this.details.push(record);
  
    sessionStorage.setItem('Details', JSON.stringify(this.details));
    this.loginForm.reset();
  }

  onDeleteRecord = (record: { fname: string; }) => {
    console.log('On delete function called');
    this.details = this.details.filter((employee) => employee.fname !== record.fname);
    sessionStorage.setItem('details', JSON.stringify(this.details));
}


displaytable() {
  if (this.details.length > 0) {
    return true;
  }
  return false;
}
order = 1;
orderStyle = 'ASC';


sortTable = (column: string | number) => {
  if (this.order === 1) {
      this.details = this.details.sort((a, b) => {
          const n1 = a[column];
          const n2 = b[column];

          let help = 0;

          if (n1 > n2) {
              help = 1;
          } else if (n1 < n2) {
              help = -1;
          }
          this.order = -1;
          this.orderStyle = 'ASC';
          return help;
      });

  } else if (this.order === -1) {
      this.details = this.details.sort((a, b) => {
          const n1 = a[column];
          const n2 = b[column];

          let help = 0;

          if (n1 < n2) {
              help = 1;
          } else if (n1 > n2) {
              help = -1;
          }
          this.order = 1;
          this.orderStyle = 'DSC';
          return help;
      });
  }
  sessionStorage.setItem('Details', JSON.stringify(this.details));
  console.log(this.details);
}

}