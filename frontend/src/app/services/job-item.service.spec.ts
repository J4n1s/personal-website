import { TestBed } from '@angular/core/testing';

import { JobItemService } from './job-item.service';

describe('JobItemService', () => {
  let service: JobItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JobItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
