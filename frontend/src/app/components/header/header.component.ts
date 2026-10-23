import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {RouterLink} from "@angular/router";
import {ContentService} from "../../services/content.service";
import {HttpErrorResponse} from "@angular/common/http";
import { AsyncPipe } from "@angular/common";

@Component({
    selector: 'app-header',
    imports: [
    RouterLink,
    AsyncPipe
],
    templateUrl: './header.component.html',
    changeDetection: ChangeDetectionStrategy.Eager,
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
