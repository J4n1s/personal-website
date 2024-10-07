import { Injectable } from '@angular/core';
import {Globals} from "../globals";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EducationItem} from "../dtos/education-item";

@Injectable({
  providedIn: 'root'
})
export class EducationItemService {

  private educationItemBaseUri: string = this.globals.apiUri + '/education';

  constructor(private httpClient: HttpClient, private globals: Globals) {
  }

  getAllEducationItems(): Observable<EducationItem[]> {
    return this.httpClient.get<EducationItem[]>(this.educationItemBaseUri);
  }
}
