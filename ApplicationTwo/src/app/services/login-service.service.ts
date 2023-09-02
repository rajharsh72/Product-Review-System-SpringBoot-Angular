import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  API_URL = "http://ec2-13-233-179-146.ap-south-1.compute.amazonaws.com:9000/api";
  requestHeader = new HttpHeaders({
    'No-Auth':'True'
  });
  
  constructor(
    private _httpClient:HttpClient
  ) { }

  login(loginData:any):Observable<any>{
    return this._httpClient.post(this.API_URL + '/authenticate', loginData);
  }
}
