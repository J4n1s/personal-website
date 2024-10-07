export class ContactInformation {
  id!: number;
  name?: string;
  mail?: string;
  phone?: string;
  message?: string;

  constructor(name?: string, mail?: string, phone?: string, message?: string) {
    this.name = name;
    this.mail = mail;
    this.phone = phone;
    this.message = message;
  }
}
