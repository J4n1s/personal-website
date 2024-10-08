import { Component } from '@angular/core';
import {NgClass, NgForOf, NgOptimizedImage, NgStyle} from "@angular/common";
import {JobItem} from "../dtos/job-item";
import {JobItemService} from "../services/job-item.service";
import {Globals} from "../globals";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-employment-history',
  standalone: true,
  imports: [
    NgClass,
    NgForOf,
    NgOptimizedImage,
    NgStyle
  ],
  templateUrl: './employment-history.component.html',
  styleUrls: ['./employment-history.component.scss', '../timeline/timeline.component.scss'],
})
export class EmploymentHistoryComponent {

  jobItems: JobItem[] | undefined;

  constructor(private jobItemService: JobItemService, private globals: Globals) {
  }

  ngOnInit() {
    this.loadJobItems();
  }

  private loadJobItems() {
    this.jobItemService.getAllJobItems().subscribe({
      next: (jobItems: JobItem[]) => {
        this.jobItems = jobItems;
        console.log(this.jobItems);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }
}
