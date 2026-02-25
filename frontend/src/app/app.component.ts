import {Component, Inject, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from "./components/header/header.component";
import {FooterComponent} from "./components/footer/footer.component";
import {DOCUMENT} from "@angular/common";
import {Globals} from "./globals";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FooterComponent],
  templateUrl: './app.component.html',
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
