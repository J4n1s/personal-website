import {Component, OnInit} from '@angular/core';
import {EmploymentHistoryComponent} from "../employment-history/employment-history.component";
import {EducationHistoryComponent} from "../education-history/education-history.component";
import {Skill} from "../../dtos/skill";
import {HttpErrorResponse} from "@angular/common/http";
import {NgForOf, NgStyle} from "@angular/common";
import {ContentService} from "../../services/content.service";

@Component({
  selector: 'app-resume',
  standalone: true,
  imports: [
    EmploymentHistoryComponent,
    EducationHistoryComponent,
    NgForOf,
    NgStyle
  ],
  templateUrl: './resume.component.html',
  styleUrl: './resume.component.scss'
})
export class ResumeComponent implements OnInit {

  skills: Skill[] | undefined;
  resumeContent!: any;

  constructor(private contentService: ContentService) {
  }

  ngOnInit() {
    this.loadSkills();
    this.loadResumeContent()
  }

  private loadSkills() {
    this.contentService.getAllSkills().subscribe({
      next: (skills: Skill[]) => {
        this.skills = skills;
        console.log(this.skills);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }

  private loadResumeContent() {
    this.contentService.getResumeContent().subscribe({
      next: (resumeContent: any) => {
        this.resumeContent = resumeContent;
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }
}
