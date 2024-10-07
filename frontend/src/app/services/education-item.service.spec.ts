import { TestBed } from '@angular/core/testing';

import { EducationItemService } from './education-item.service';

describe('EducationItemService', () => {
  let service: EducationItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EducationItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
