export class JobItem {
  startingYear: number;
  endingYear: number;
  logoUrl: string;
  employerName: string;
  jobTitle: string;
  jobDescription: string;


  constructor(startingYear: number, endingYear: number, logoUrl: string, employerName: string, jobTitle: string, jobDescription: string) {
    this.startingYear = startingYear;
    this.endingYear = endingYear;
    this.logoUrl = logoUrl;
    this.employerName = employerName;
    this.jobTitle = jobTitle;
    this.jobDescription = jobDescription;
  }
}
