import {Component} from '@angular/core';
import {EducationItemService} from '../services/education-item.service'
import {EducationItem} from "../dtos/education-item";
import {HttpErrorResponse} from "@angular/common/http";
import {NgClass, NgForOf, NgOptimizedImage} from "@angular/common";
import {Globals} from "../globals";


@Component({
  selector: 'app-timeline',
  standalone: true,
  imports: [
    NgClass,
    NgForOf,
    NgOptimizedImage
  ],
  templateUrl: './timeline.component.html',
  styleUrl: './timeline.component.scss'
})
export class TimelineComponent {

  educationItems: EducationItem[] | undefined;

  constructor(private educationItemService: EducationItemService, private globals: Globals) {
  }

  ngOnInit() {
    this.loadEducationItems();
  }

  private loadEducationItems() {
    this.educationItemService.getAllEducationItems().subscribe({
      next: (educationItems: EducationItem[]) => {
        this.educationItems = educationItems;
        console.log(this.educationItems);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }

  protected readonly toString = toString;
}
