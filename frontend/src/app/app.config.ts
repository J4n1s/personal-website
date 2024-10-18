import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import {provideHttpClient, withFetch} from "@angular/common/http";

import { routes } from './app.routes';
import {LanguageInterceptor} from "./interceptors/language.service";

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(withFetch()),
    { provide: HTMLAllCollection, useClass: LanguageInterceptor, multi: true },
  ]
};
