import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Globals} from "../globals";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TextService {

  private textBaseUri: string = this.globals.apiUri + '/text';

  constructor(private httpClient: HttpClient, private globals: Globals) { }

  getContactFormText(): Observable<any> {
    return this.httpClient.get<any>(this.textBaseUri + '/contact-form');
  }
}
