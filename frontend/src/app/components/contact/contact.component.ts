import { Component } from '@angular/core';
import {Validators, ReactiveFormsModule, FormBuilder, FormGroup, FormControl} from "@angular/forms";
import {ContactInformation} from "../../dtos/contact-information";
import {ContactService} from "../../services/contact-service";
import {NgIf} from "@angular/common";

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
export class ContactComponent {

  submitted = false;
  error = false;
  contactInformation?: ContactInformation;
  contactForm!: FormGroup;

  constructor(private contactService: ContactService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.contactForm = new FormGroup({
      name: new FormControl("", Validators.required),
      mail: new FormControl("", [Validators.required, Validators.email]),
      phone: new FormControl(""),
      message: new FormControl("", Validators.required)
      }
    )
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

}
