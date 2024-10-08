import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Globals} from "../globals";
import {JobItem} from "../dtos/job-item";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class JobItemService {

  private jobItemBaseUri: string = this.globals.apiUri + '/jobs';

  constructor(private httpClient: HttpClient, private globals: Globals) { }

  getAllJobItems(): Observable<JobItem[]> {
    return this.httpClient.get<JobItem[]>(this.jobItemBaseUri);
  }
}
