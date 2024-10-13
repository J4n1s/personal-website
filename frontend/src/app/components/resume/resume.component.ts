import {Component, OnInit} from '@angular/core';
import {EmploymentHistoryComponent} from "../employment-history/employment-history.component";
import {EducationHistoryComponent} from "../education-history/education-history.component";
import {Skill} from "../../dtos/skill";
import {ResumeService} from "../../services/resume.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgForOf, NgStyle} from "@angular/common";
import {TextService} from "../../services/text.service";

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
  textContent!: any;

  constructor(private resumeService: ResumeService,
              private textService: TextService) {
  }

  ngOnInit() {
    this.loadSkills();
    this.loadTextContent()
  }

  private loadSkills() {
    this.resumeService.getAllSkills().subscribe({
      next: (skills: Skill[]) => {
        this.skills = skills;
        console.log(this.skills);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }

  private loadTextContent() {
    this.textService.getResumeText().subscribe({
      next: (textContent: any) => {
        this.textContent = textContent;
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }
}
