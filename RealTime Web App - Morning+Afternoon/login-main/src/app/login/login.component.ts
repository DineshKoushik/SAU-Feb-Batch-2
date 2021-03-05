import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username : string;
  password : string;

  constructor(private loginServiceService: LoginserviceService, private __router: Router) {
    this.username = "";
    this.password = "";

   }

  ngOnInit(): void {

    this.loginServiceService.hello().subscribe((response) => {
      console.log(response);

    });
  }

  submit = () => {
    this.loginServiceService.login(this.username,this.password).subscribe((response) => {
      console.log(response.id);
      this.__router.navigate(['/home'] ,{ state: { id : response.id } } );

  })
}

}
