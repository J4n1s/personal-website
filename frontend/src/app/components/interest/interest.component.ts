import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {ContentService} from "../../services/content.service";
import {HttpErrorResponse} from "@angular/common/http";
import { NgClass, NgOptimizedImage } from "@angular/common";
import {Globals} from "../../globals";

@Component({
    selector: 'app-interest',
    imports: [
    NgClass,
    NgOptimizedImage
],
    templateUrl: './interest.component.html',
    changeDetection: ChangeDetectionStrategy.Eager,
    styleUrl: './interest.component.scss'
})
export class InterestComponent implements OnInit {

  interestsContent!: any;
  protected baseUri: string = this.globals.baseUri;

  constructor(private contentService: ContentService, private globals: Globals) {
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
