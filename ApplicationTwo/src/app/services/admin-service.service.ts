import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserServiceService } from './user-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  constructor(
    private _httpClient:HttpClient,
    private _userService: UserServiceService
  ) { }

  ADMIN_URL = "http://ec2-13-233-179-146.ap-south-1.compute.amazonaws.com:9000/api/admin";

  updateState(reviewId:any, state:any):Observable<any>{
    let t= this._userService.getToken();
    var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    const httpOption = {
      headers: headerObject
    };

    return this._httpClient.post(`${this.ADMIN_URL}/update/${reviewId}`, state, httpOption );

  }
}
