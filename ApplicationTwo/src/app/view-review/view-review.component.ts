import { DialogRef } from '@angular/cdk/dialog';
import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-view-review',
  templateUrl: './view-review.component.html',
  styleUrls: ['./view-review.component.css']
})
export class ViewReviewComponent implements OnInit {
  constructor(
    private _userService:UserServiceService,
    private _router:ActivatedRoute,
    private _location:Location
  ){}

  res: any;
  currentUser:any;
  msg:any;
  ngOnInit(): void {
    console.log(this._router.snapshot.params['productId']);
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

  back(){
    this._location.back();
  }


  
}
