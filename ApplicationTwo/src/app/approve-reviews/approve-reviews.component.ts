import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminServiceService } from '../services/admin-service.service';
import { UserServiceService } from '../services/user-service.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-approve-reviews',
  templateUrl: './approve-reviews.component.html',
  styleUrls: ['./approve-reviews.component.css']
})
export class ApproveReviewsComponent implements OnInit {

  constructor(
    private _userService:UserServiceService,
    private _router:ActivatedRoute,
    private _adminService:AdminServiceService,
    private _location: Location
  ){  }

  msg:any;
  res:any;
  currentUser:any
  ngOnInit(): void {
    this._userService.getProductById(this._router.snapshot.params['productId']).subscribe((data)=>{
      if(data.review.length===0){
        this.msg="no reviews yet..";
        this.res = '';
      }
      this.res = data;
      this.msg='';
  });

  this.currentUser = this._userService.getCurrentUser();
  }

  approveRequest(reviewId:any){
    this._adminService.updateState(reviewId, true).subscribe((res)=>{
      window.location.reload();
    });
  }

  rejectRequest(reviewId:any){
    this._adminService.updateState(reviewId, false).subscribe((res)=>{
      window.location.reload();
    });
  }

  back(){
    this._location.back();
  }


}
