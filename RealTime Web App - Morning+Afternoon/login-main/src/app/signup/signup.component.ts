import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user: User;
  confirmpassword: string;
  error: string;

  constructor(private loginserviceService: LoginserviceService, private __router: Router) {
    this.error = "";

    this.user = {
      fName: "adf",
      lName: "",
      age: 0,
      dob: "string",
      username: "string",
      email: "string",
      password: "string",
    }

  }

  ngOnInit(): void {
  }



  submit() {
    if (this.confirmpassword != this.user.password) {
      this.error = "Password doesnt match";
      return;
    }
    else {
      this.loginserviceService.signup(this.user).subscribe((response) => {
        console.log(response);
        console.log("Signed up");
        this.__router.navigate(['']);

      });
    }



  }

}
