import {Component, OnInit} from '@angular/core';
import {Validators, ReactiveFormsModule, FormBuilder, FormGroup, FormControl} from "@angular/forms";
import {ContactInformation} from "../../dtos/contact-information";
import {ContactService} from "../../services/contact-service";
import {NgIf} from "@angular/common";
import {TextService} from "../../services/text.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.scss'
})
export class ContactComponent implements OnInit {

  submitted = false;
  error = false;
  contactInformation?: ContactInformation;
  contactForm!: FormGroup;
  textContent!: any;

  constructor(private contactService: ContactService,
              private textService: TextService) {
  }

  ngOnInit() {
    this.contactForm = new FormGroup({
      name: new FormControl("", Validators.required),
      mail: new FormControl("", [Validators.required, Validators.email]),
      phone: new FormControl(""),
      message: new FormControl("", Validators.required)
      }
    )
    this.loadTextContent();
  }

  onSubmit() {
    if (this.contactForm.valid) {
      let contactInformation: ContactInformation = new ContactInformation(
        this.contactForm.value.name, this.contactForm.value.mail, this.contactForm.value.phone, this.contactForm.value.message
      )
      this.submitted = true;
      this.contactService.postContactForm(contactInformation).subscribe(({
        next: (contactInformation: ContactInformation) => {
          this.contactForm.reset();
          this.contactInformation = contactInformation;
        }, error: err => {
          this.error = true;
        }
      }))
    }
  }

  private loadTextContent() {
    this.textService.getContactFormText().subscribe({
      next: (textContent: any) => {
        this.textContent = textContent;
        console.log(this.textContent);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    })
  }

}
