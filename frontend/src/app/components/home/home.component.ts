import { Component } from '@angular/core';
import {TimelineComponent} from "../timeline/timeline.component";
import {EmploymentHistoryComponent} from "../employment-history/employment-history.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    TimelineComponent,
    EmploymentHistoryComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
