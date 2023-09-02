import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterUserService {
  constructor(
    private _httpClient:HttpClient
  ) { }

  API_URL = "http://ec2-13-233-179-146.ap-south-1.compute.amazonaws.com:9000/api";

  register(userData:any):Observable<any>{
    return this._httpClient.post(this.API_URL + '/user', userData);
  }
}
