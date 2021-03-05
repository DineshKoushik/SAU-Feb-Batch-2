import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  id: string;
  name : string;
  constructor(private loginserviceService: LoginserviceService, private __router: Router) {
    console.log(this.__router.getCurrentNavigation().extras.state.id);
    this.id = (this.__router.getCurrentNavigation().extras.state.id);
    this.loginserviceService.home(this.id).subscribe((response) => {
      console.log(response);
      this.name = response.fName + response.lName;

    });

  }

  ngOnInit(): void {
    
  }


}
