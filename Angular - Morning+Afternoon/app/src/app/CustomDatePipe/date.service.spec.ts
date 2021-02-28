import { TestBed } from '@angular/core/testing';

import { CustomDateService } from './date.service';

describe('CustomDateService', () => {
  let service: CustomDateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomDateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});