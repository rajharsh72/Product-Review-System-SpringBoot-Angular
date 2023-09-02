import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginServiceService } from './services/login-service.service';
import { UserServiceService } from './services/user-service.service';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { RegisterUserService } from './services/register-user.service';
import { ViewReviewComponent } from './view-review/view-review.component';
import { AddReviewComponent } from './add-review/add-review.component';
import { ApproveReviewsComponent } from './approve-reviews/approve-reviews.component';
import { authInterceptorProviders } from './_auth/auth.interceptor';
// import { authGuard } from './_auth/auth.guard';
// import { AuthInterceptor } from './_auth/auth.interceptor';
// import { mapToCanActivate } from '@angular/router';

 

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ForbiddenComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    ViewReviewComponent,
    AddReviewComponent,
    ApproveReviewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    HttpClientModule,
    MatDialogModule,
    MatFormFieldModule,
    MatTableModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [LoginServiceService, UserServiceService, RegisterUserService, authInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
