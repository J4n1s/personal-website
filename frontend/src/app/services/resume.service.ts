import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Globals} from "../globals";
import {Observable} from "rxjs";
import {Skill} from "../dtos/skill";

@Injectable({
  providedIn: 'root'
})
export class ResumeService {

  private resumeBaseUri: string = this.globals.apiUri + '/resume';
  private skillsBaseUri: string = this.resumeBaseUri + '/skills';

  constructor(private httpClient: HttpClient, private globals: Globals) { }

  getAllSkills(): Observable<Skill[]> {
    return this.httpClient.get<Skill[]>(this.skillsBaseUri);
  }
}
