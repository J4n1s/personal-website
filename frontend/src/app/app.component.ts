import {Component, Inject, OnInit, DOCUMENT, ChangeDetectionStrategy} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from "./components/header/header.component";
import {FooterComponent} from "./components/footer/footer.component";

import {Globals} from "./globals";

@Component({
    selector: 'app-root',
    imports: [RouterOutlet, HeaderComponent, FooterComponent],
    templateUrl: './app.component.html',
    changeDetection: ChangeDetectionStrategy.Eager,
    styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'Janis Schneeberger, B.Sc.';

  constructor(@Inject(DOCUMENT) private document: Document, private globals: Globals) {
  }

  ngOnInit() {
    this.document.documentElement.lang = this.globals.userLanguage;
  }
}
