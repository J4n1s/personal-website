import { Component } from '@angular/core';
import {EducationHistoryComponent} from "../education-history/education-history.component";
import {EmploymentHistoryComponent} from "../employment-history/employment-history.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    EducationHistoryComponent,
    EmploymentHistoryComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
