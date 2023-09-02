import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  constructor(
    private _userService:UserServiceService,
    private _router:Router
  ){}

  products:any;
  ngOnInit(): void {
    this._userService.getAllProducts().subscribe((res)=>{
      this.products = res;
      console.log(this.products);
    })
  }

  currentUser = this._userService.getCurrentUser();

  logout(){
    this._userService.clearStorage();
    this._router.navigate(['home']);
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
