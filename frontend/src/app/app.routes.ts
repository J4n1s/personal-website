import { Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {ContactComponent} from "./components/contact/contact.component";
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";
import {ResumeComponent} from "./components/resume/resume.component";
import {InterestComponent} from "./components/interest/interest.component";

export const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'contact', component: ContactComponent },
  { path: 'resume', component: ResumeComponent},
  { path: 'interest', component: InterestComponent},
  { path: '**', component: PageNotFoundComponent}
];
