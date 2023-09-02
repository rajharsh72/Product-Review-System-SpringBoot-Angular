import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { catchError, Observable, throwError } from "rxjs";
import { UserServiceService } from "../services/user-service.service";

@Injectable({
    providedIn: 'root'
  })
  
export class AuthInterceptor implements HttpInterceptor{
    constructor(
        private _userService:UserServiceService,
        private _router: Router
    ){}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const token = this._userService.getToken();
        const auth = 'Bearer '+token;
        let tokenizedReq = req;
        if(token!=null){
            tokenizedReq = req.clone({
                headers: req.headers.set('Authorization',auth)
            })
        }
        return next.handle(tokenizedReq);
    }

}

export const authInterceptorProviders = [
    {
        provide:HTTP_INTERCEPTORS,
        useClass:AuthInterceptor,
        multi:true
    }
];