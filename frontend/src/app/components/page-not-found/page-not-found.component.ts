import {Component, OnInit} from '@angular/core';
import {ContentService} from "../../services/content.service";
import {HttpErrorResponse} from "@angular/common/http";
import {AsyncPipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-page-not-found',
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf
  ],
  templateUrl: './page-not-found.component.html',
  styleUrl: './page-not-found.component.scss'
})
export class PageNotFoundComponent implements OnInit {
  errorContent!: any;

  constructor(private contentService: ContentService) {
  }

  ngOnInit() {
    this.loadErrorContent();
  }

  private loadErrorContent() {
    this.contentService.get404Content().subscribe({
      next: (errorContent: any) => {
        this.errorContent = errorContent;
      },
      error: (err: HttpErrorResponse) => {
        console.log(err)
      }
    })
  }
}
