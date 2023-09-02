import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent  {

  constructor(
    private _dialog:MatDialog
  ){}
  openLoginForm(){
    this._dialog.open(LoginComponent);
  }

  openRegistrationForm(){
    this._dialog.open(RegisterComponent);
  }

  
}
