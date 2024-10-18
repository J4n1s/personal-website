import {Component, OnInit} from '@angular/core';
import {EducationItemService} from '../../services/education-item.service'
import {EducationItem} from "../../dtos/education-item";
import {HttpErrorResponse} from "@angular/common/http";
import {AsyncPipe, NgClass, NgForOf, NgIf, NgOptimizedImage} from "@angular/common";
import {Globals} from "../../globals";


@Component({
  selector: 'app-education-history',
  standalone: true,
    imports: [
        NgClass,
        NgForOf,
        NgOptimizedImage,
        AsyncPipe,
        NgIf
    ],
  templateUrl: './education-history.component.html',
  styleUrls: ['./education-history.component.scss', '../../styles/timeline.scss']
})
export class EducationHistoryComponent implements OnInit {

  contentLoaded: Promise<boolean> = Promise.resolve(false);
  educationItems!: EducationItem[];

  constructor(private educationItemService: EducationItemService) {
  }

  ngOnInit() {
    this.loadEducationItems();
  }

  private loadEducationItems() {
    this.educationItemService.getAllEducationItems().subscribe({
      next: (educationItems: EducationItem[]) => {
        this.educationItems = educationItems;
        this.contentLoaded = Promise.resolve(true);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }
}
