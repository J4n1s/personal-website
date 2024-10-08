import { Component } from '@angular/core';
import {Validators, ReactiveFormsModule, FormBuilder} from "@angular/forms";
import {ContactInformation} from "../../dtos/contact-information";
import {ContactService} from "../../services/contact-service";

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.scss'
})
export class ContactComponent {

  contactForm = this.formBuilder.nonNullable.group({
    name: [''],
    mail: [''],
    phone: [''],
    message: ['', Validators.required],
  })

  constructor(private contactService: ContactService,
              private formBuilder: FormBuilder) {
  }

  onSubmit() {
    if (this.contactForm.valid) {
      let contactInformation: ContactInformation = new ContactInformation(
        this.contactForm.value.name, this.contactForm.value.mail, this.contactForm.value.phone, this.contactForm.value.message
      )
      this.contactService.postContactForm(contactInformation).subscribe(({
        next: () => {
          console.log("Success");
        }, error: err => {
          console.log(err);
        }
      }))
    }
    console.warn(this.contactForm.value)
  }

  /*
  postMessage(form: NgForm) {
    if (form.valid) {
      this.contactService.postContactForm(this.contactInformation).subscribe({
        next: () => {

        }
      });
    }
  }

   */

  protected readonly onsubmit = onsubmit;
}
