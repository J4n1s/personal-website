import {Component, OnInit} from '@angular/core';
import {EducationHistoryComponent} from "../education-history/education-history.component";
import {EmploymentHistoryComponent} from "../employment-history/employment-history.component";
import {ContentService} from "../../services/content.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    EducationHistoryComponent,
    EmploymentHistoryComponent,
    NgIf
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {

  homeContent!: any;

  constructor(private contentService: ContentService) {
  }

  ngOnInit() {
    this.loadHomeContent();
  }

  private loadHomeContent(): void {
    this.contentService.getHomeContent().subscribe({
      next: (homeContent: any) => {
        this.homeContent = homeContent;
      },
      error: (error: HttpErrorResponse) => {
        console.log(error);
      }
    })
  }
}
