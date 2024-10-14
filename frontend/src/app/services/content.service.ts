import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Globals} from "../globals";
import {Observable} from "rxjs";
import {Skill} from "../dtos/skill";

@Injectable({
  providedIn: 'root'
})
export class ContentService {

  private contentBaseUri: string = this.globals.apiUri + '/content';

  constructor(private httpClient: HttpClient, private globals: Globals) { }

  getContactFormContent(): Observable<any> {
    return this.httpClient.get<any>(this.contentBaseUri + '/contact-form');
  }

  getResumeContent(): Observable<any> {
    return this.httpClient.get<any>(this.contentBaseUri + '/resume');
  }

  getAllSkills(): Observable<Skill[]> {
    return this.httpClient.get<Skill[]>(this.contentBaseUri + '/skills');
  }
}
