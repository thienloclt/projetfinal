import { TestBed, inject } from '@angular/core/testing';

import { EnseignementService } from './enseignement.service';

describe('EnseignementService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EnseignementService]
    });
  });

  it('should be created', inject([EnseignementService], (service: EnseignementService) => {
    expect(service).toBeTruthy();
  }));
});
