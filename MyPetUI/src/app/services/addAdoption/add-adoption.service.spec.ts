import { TestBed } from '@angular/core/testing';

import { AddAdoptionService } from './add-adoption.service';

describe('AddAdoptionService', () => {
  let service: AddAdoptionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddAdoptionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
