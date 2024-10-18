import { Injectable } from '@angular/core';
import {HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHandlerFn} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Globals} from "../globals";

@Injectable({
  providedIn: 'root', // Ensures this interceptor is available throughout your app
})
export class LanguageInterceptor implements HttpInterceptor {

  constructor(private globals: Globals) {
  }

  intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    // Clone the request and add the Accept-Language header
    const modifiedReq = req.clone({
      setHeaders: {
        'Accept-Language': this.globals.userLanguage
      }
    });

    // Pass the modified request to the next handler
    return next.handle(modifiedReq);
  }
}
