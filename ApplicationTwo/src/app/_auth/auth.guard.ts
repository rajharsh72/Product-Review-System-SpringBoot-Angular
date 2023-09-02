import { ActivatedRouteSnapshot, CanActivate, CanActivateChildFn, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import {Injectable} from '@angular/core'
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class AuthGuard implements CanActivate{
    constructor(
        private _userService:UserServiceService,
        private _router:Router
    ){}
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        if(this._userService.getToken() && this._userService.getCurrentRole() === "ADMIN"){
            return true;
        }
        // if(this._userService.getToken() && this._userService.getCurrentRole() === "USER"){
        //     return true;
        // }
        else{
            this._router.navigate(['forbidden']);
            this._userService.clearStorage();
            return false;
        }
    }    
}
