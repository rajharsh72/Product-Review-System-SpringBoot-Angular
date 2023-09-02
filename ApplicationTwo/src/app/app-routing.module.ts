import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddReviewComponent } from './add-review/add-review.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ApproveReviewsComponent } from './approve-reviews/approve-reviews.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ViewReviewComponent } from './view-review/view-review.component';
import { AuthGuard } from './_auth/auth.guard';

const routes: Routes = [
  {path:'', component:HomeComponent, pathMatch:'full'},
  {path:'home', component:HomeComponent},
  {path:'userDashboard', component:UserDashboardComponent},
  {path:'adminDashboard', component:AdminDashboardComponent, canActivate:[AuthGuard]},
  {path:'view-review/:productId', component:ViewReviewComponent},
  {path: 'forbidden', component:ForbiddenComponent},
  {path: 'approve-review/:productId', component:ApproveReviewsComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
