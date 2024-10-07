export class EducationItem {
  startingYear: number;
  endingYear: number;
  logoUrl: string;
  schoolName: string;
  schoolNameAbbreviation: string;
  studyTitle: string;
  description: string;


  constructor(startingYear: number, endingYear: number, logoUrl: string, schoolName: string, schoolNameAbbreviation: string, studyTitle: string, description: string) {
    this.startingYear = startingYear;
    this.endingYear = endingYear;
    this.logoUrl = logoUrl;
    this.schoolName = schoolName;
    this.schoolNameAbbreviation = schoolNameAbbreviation;
    this.studyTitle = studyTitle;
    this.description = description;
  }
}
