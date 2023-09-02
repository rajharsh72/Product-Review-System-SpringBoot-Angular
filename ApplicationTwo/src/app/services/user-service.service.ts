import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  BASE_URL = "http://ec2-13-233-179-146.ap-south-1.compute.amazonaws.com:9000/api";
  constructor(private _httpClient:HttpClient) { }

  public setRoles(roles:[]){
    localStorage.setItem('roles', JSON.stringify(roles));
  }

  public getRoles():[]{
    return JSON.parse(localStorage.getItem('roles')!);
  }

  public setToken(jwtToken:string){
    localStorage.setItem("jwtToken", jwtToken);
  }

  public getToken():string{
    return localStorage.getItem('jwtToken')!;
  }

  public setCurrentRole(role:string){
    localStorage.setItem('currentRole', role);
  }

  public getCurrentRole():string{
    return localStorage.getItem('currentRole')!;
  }


  public clearStorage(){
    localStorage.clear();
  }
  
  public setCurrentUser(username:string){
    localStorage.setItem('currentUser', username);
  }

  public getCurrentUser():string{
    return localStorage.getItem('currentUser')!;
  }

  searchProduct(keyword:any):Observable<any>{
    // let t= this.getToken();
    // var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    // const httpOptions = {
    //   headers: headerObject
    // };
    return this._httpClient.get(`${this.BASE_URL}/products/${keyword}`);
  }

  getProductById(productId:any):Observable<any>{
    let t= this.getToken();
    var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    const httpOption = {
      headers: headerObject
    };
    return this._httpClient.post(`${this.BASE_URL}/products/${productId}`, productId, httpOption);
  }

  addReview(review:any, productId:any):Observable<any>{
    let t= this.getToken();
    var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    const httpOption = {
      headers: headerObject
    };
    return this._httpClient.post(`${this.BASE_URL}/add-review/${productId}`, review, httpOption);
  }

  getAllProducts():Observable<any>{
    let t= this.getToken();
    var headerObject = new HttpHeaders().set("Authorization", "Bearer "+t);
    const httpOption = {
      headers: headerObject
    };
    return this._httpClient.get(`${this.BASE_URL}/products`, httpOption);

  }

  public countUsers():Observable<any>{
    return this._httpClient.get(`${this.BASE_URL}/user/count`);
  }

  public countProducts():Observable<any>{
    return this._httpClient.get(`${this.BASE_URL}/products/count`);
  }

  public countReviews():Observable<any>{
    return this._httpClient.get(`${this.BASE_URL}/productReviews/count`);
  }

  
}
