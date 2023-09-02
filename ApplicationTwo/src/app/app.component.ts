import { Component, OnInit } from '@angular/core';
import { UserServiceService } from './services/user-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(
    private _userService:UserServiceService
  ){}

  usersCount:any;
  productCount:any;
  reviewsCount:any;
  ngOnInit(): void {

    this._userService.countUsers().subscribe((res)=>{
      this.usersCount = res;
      console.log(this.usersCount);
    });

    this._userService.countProducts().subscribe((res)=>{
      this.productCount = res;
      console.log(this.productCount);
    });

    this._userService.countReviews().subscribe((res)=>{
      this.reviewsCount = res;
      console.log(this.reviewsCount);
    })
  }
  title = 'Product Community Application';
}
