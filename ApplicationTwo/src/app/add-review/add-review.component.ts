import { DialogRef } from '@angular/cdk/dialog';
import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.css']
})
export class AddReviewComponent implements OnInit {

  constructor(
    private _fb:FormBuilder,
    private _userService:UserServiceService,
    @Inject(MAT_DIALOG_DATA) private _data:any,
    private _dialogRef:DialogRef
  ){}
  reviewForm = new FormGroup({
    'review': new FormControl('', [Validators.required, Validators.maxLength(400), Validators.minLength(20)]),
    'rating':new FormControl('', [Validators.required, Validators.max(5)])
  });

  productName:any;
  productId:any;
  msg:any;
  succMsg:any;
  ngOnInit(): void {
    this.productId = this._data.productId;
    this.productName = this._data.productName;

  }

  addReview(){
    if(this.reviewForm.valid){
      console.log(this.reviewForm.value);
    this._userService.addReview(this.reviewForm.value, this.productId).subscribe((res)=>{
      // this._dialogRef.close();
      this.succMsg = "Review added successfully";
      this.msg = '';
      
    });
  }
  else{
    this.succMsg = '';
    this.msg = "Invalid review size or rating";

  }
  }

  close(){
    this._dialogRef.close();
  }

}
