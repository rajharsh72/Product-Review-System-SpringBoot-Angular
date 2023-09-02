import { Component, OnInit } from '@angular/core';
import { RegisterUserService } from '../services/register-user.service';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(
    private _registerService:RegisterUserService,
    private _dialogRef:MatDialogRef<RegisterComponent>,
    private _dialog:MatDialog
  ){}
  successMsg='';
  errorMsg=''
  registrationForm = new FormGroup({
    'email': new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
    'first_name': new FormControl('',[Validators.required, Validators.pattern('[a-zA-Z ]*')]),
    'last_name':new FormControl('', Validators.pattern('[a-zA-Z ]*')),
    'password':new FormControl('', Validators.required)
  });

  register(){
    //console.log(this.registrationForm.value);
    if(this.registrationForm.valid){
    this._registerService.register(this.registrationForm.value).subscribe((res) => {
      this.successMsg = "User registered..";
      this.errorMsg = '';
    },
      (err) => {
        this.errorMsg = "Cannot register user, try again!";
        this.successMsg = '';
    });
  }
  }

  openLoginForm(){
    this._dialogRef.close();
    this._dialog.open(LoginComponent);
 
  }

}

