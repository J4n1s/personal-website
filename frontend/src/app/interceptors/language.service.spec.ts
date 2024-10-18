import { TestBed } from '@angular/core/testing';

import { LanguageInterceptor } from './language.service';

describe('LanguageService', () => {
  let service: LanguageInterceptor;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LanguageInterceptor);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
