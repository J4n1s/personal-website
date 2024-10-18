import {Component, OnInit} from '@angular/core';
import {AsyncPipe, NgIf, NgOptimizedImage} from "@angular/common";
import {ContentService} from "../../services/content.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [
    NgOptimizedImage,
    AsyncPipe,
    NgIf
  ],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.scss'
})
export class FooterComponent implements OnInit {

  mail = "janis.schneeberger@outlook.com";
  contentLoaded: Promise<boolean> = Promise.resolve(false);
  footerContent!: any;

  constructor(private contentService: ContentService) {
  }

  ngOnInit(): void {
    this.loadFooterContent();
  }

  private loadFooterContent() {
    this.contentService.getFooterContent().subscribe({
      next: (footerContent: any) => {
        this.footerContent = footerContent;
        this.contentLoaded = Promise.resolve(true);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }

}
