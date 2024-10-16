import {Component, OnInit} from '@angular/core';
import {ContentService} from "../../services/content.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgClass, NgForOf} from "@angular/common";

@Component({
  selector: 'app-interest',
  standalone: true,
  imports: [
    NgForOf,
    NgClass
  ],
  templateUrl: './interest.component.html',
  styleUrl: './interest.component.scss'
})
export class InterestComponent implements OnInit {

  interestsContent!: any;

  constructor(private contentService: ContentService) {
  }

  ngOnInit() {
    this.loadInterestsContent();
  }

  private loadInterestsContent() {
    this.contentService.getInterestsContent().subscribe({
      next: (interestsContent: any) => {
        this.interestsContent = interestsContent;
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }

}
