import {Injectable} from "@angular/core";
import {Globals} from "../globals";
import {HttpClient} from "@angular/common/http";
import {ContactInformation} from "../dtos/contact-information";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private contactBaseUri: string = this.globals.apiUri + '/contact'

  constructor(private httpClient: HttpClient, private globals: Globals) {
  }

  postContactForm(contactInformation: ContactInformation): Observable<ContactInformation> {
    return this.httpClient.post<ContactInformation>(this.contactBaseUri, contactInformation);
  }
}
