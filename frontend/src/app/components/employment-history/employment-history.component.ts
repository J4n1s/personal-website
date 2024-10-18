import {Component, OnInit} from '@angular/core';
import {AsyncPipe, NgClass, NgForOf, NgIf, NgOptimizedImage, NgStyle} from "@angular/common";
import {JobItem} from "../../dtos/job-item";
import {JobItemService} from "../../services/job-item.service";
import {Globals} from "../../globals";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-employment-history',
  standalone: true,
  imports: [
    NgClass,
    NgForOf,
    NgOptimizedImage,
    NgStyle,
    AsyncPipe,
    NgIf
  ],
  templateUrl: './employment-history.component.html',
  styleUrls: ['./employment-history.component.scss', '../../styles/timeline.scss'],
})
export class EmploymentHistoryComponent implements OnInit {

  contentLoaded: Promise<boolean> = Promise.resolve(false);
  jobItems!: JobItem[];

  constructor(private jobItemService: JobItemService, private globals: Globals) {
  }

  ngOnInit() {
    this.loadJobItems();
  }

  private loadJobItems() {
    this.jobItemService.getAllJobItems().subscribe({
      next: (jobItems: JobItem[]) => {
        this.jobItems = jobItems;
        this.contentLoaded = Promise.resolve(true);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }
}
