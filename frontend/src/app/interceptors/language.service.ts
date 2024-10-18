import { Injectable } from '@angular/core';
import {HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHandlerFn} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root', // Ensures this interceptor is available throughout your app
})
export class LanguageInterceptor implements HttpInterceptor {

  constructor() {
  }

  intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    // Get the user's preferred language from the browser
    const userLanguage = navigator.language || 'en-US';

    // Clone the request and add the Accept-Language header
    const modifiedReq = req.clone({
      setHeaders: {
        'Accept-Language': userLanguage
      }
    });

    // Pass the modified request to the next handler
    return next.handle(modifiedReq);
  }
}
