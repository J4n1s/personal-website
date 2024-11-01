import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Globals {

  readonly baseUri: string = this.findBackendUrl();
  readonly apiUri: string = this.baseUri + '/api/v1';

  readonly userLanguage: string = this.findLanguage();

  private findBackendUrl(): string {
    if (window.location.port === '4200') { // local `ng serve`, backend at localhost:8080
      return 'http://localhost:8080';
    } else {
      // assume deployed somewhere and backend is available at same host/port as frontend
      return window.location.protocol + '//' + window.location.host;
    }
  }

  private findLanguage(): string {
    return navigator.language || 'de';
  }


}
