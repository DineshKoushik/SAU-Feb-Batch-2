import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './model/user';


@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private http:HttpClient) { }

  hello = () : Observable<any> => {
    return this.http.get<any>("http://aca274277579.ngrok.io/ordermgmt/hello");
  }

  signup = (user : User) : Observable<any> => {
    return this.http.post<any>("http://aca274277579.ngrok.io/user/signup",user);
  }

  login = (username : String , password : String) : Observable<any> => {
    return this.http.post<any>("http://aca274277579.ngrok.io/user/login",{'username':username,'password':password});
  }

  home = (id:string) : Observable<any> => {
    return this.http.get<any>("http://aca274277579.ngrok.io/user/details/"+id);
  }
  
}
