import { DecimalPipe } from '@angular/common';
import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AddReviewComponent } from '../add-review/add-review.component';
import { UserServiceService } from '../services/user-service.service';
import { ViewReviewComponent } from '../view-review/view-review.component';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor(
    private _userService:UserServiceService,
    private _router:Router,
    private _dialog:MatDialog
  ){}
  ngOnInit(): void {
    if(this._userService.getCurrentRole() === "ADMIN"){
      this._router.navigate(['forbidden']);
    }
    //console.log(this._userService.getToken());
  }

  searchQuery:any;
  message:any;
  productData:any;
  currentUser = this._userService.getCurrentUser();
  err:any;
  logout(){
    this._userService.clearStorage();
    this._router.navigate(['home']);
  }

  searchProduct(){
    
    if(this.searchQuery != ''){
    this._userService.searchProduct(this.searchQuery).subscribe((res)=>{
      console.log(res);
      
      if(res.length == 0){
        this.message = "No data found..."
        this.productData ='';
      }
      else{
        this.productData = res;
        this.message= '';
      }
    }); 
    this.err='';
    }

    else{
      this.message = '';
      this.err = "Please enter a value...";
      console.log(this.err);
    }
  }

  addReview(data:any){
    this._dialog.open(AddReviewComponent,{
      data
    });

  }

  calculateAvgRating(reviews:any[]):number{
    if(reviews && reviews.length > 0){
      const totalRatings = reviews.length;
      const sum = reviews.reduce((total, review) => total + review.rating, 0);
      return sum/totalRatings;
    }
    else{
      return 0;
    }
  }

}
