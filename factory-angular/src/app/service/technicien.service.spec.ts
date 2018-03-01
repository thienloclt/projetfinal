import { TestBed, inject } from '@angular/core/testing';

import { TechnicienService } from './technicien.service';

describe('TechnicienService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TechnicienService]
    });
  });

  it('should be created', inject([TechnicienService], (service: TechnicienService) => {
    expect(service).toBeTruthy();
  }));
});
