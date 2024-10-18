import {Component, OnInit} from '@angular/core';
import {RouterLink} from "@angular/router";
import {ContentService} from "../../services/content.service";
import {HttpErrorResponse} from "@angular/common/http";
import {AsyncPipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    RouterLink,
    AsyncPipe,
    NgIf
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {

  contentLoaded: Promise<boolean> = Promise.resolve(false);
  headerContent!: any;

  constructor(private contentService: ContentService,) {
  }

  ngOnInit() {
    this.loadHeaderContent();
  }

  private loadHeaderContent() {
    this.contentService.getHeaderContent().subscribe({
      next: (headerContent: any) => {
        this.headerContent = headerContent;
        this.contentLoaded = Promise.resolve(true);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }

}
