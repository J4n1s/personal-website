import { Component } from '@angular/core';
import {EmploymentHistoryComponent} from "../employment-history/employment-history.component";
import {EducationHistoryComponent} from "../education-history/education-history.component";

@Component({
  selector: 'app-resume',
  standalone: true,
  imports: [
    EmploymentHistoryComponent,
    EducationHistoryComponent
  ],
  templateUrl: './resume.component.html',
  styleUrl: './resume.component.scss'
})
export class ResumeComponent {

}
