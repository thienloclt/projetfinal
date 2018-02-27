import { TestBed, inject } from '@angular/core/testing';

import { CentreEquestreService } from './centreequestre.service';

describe('CentreEquestreService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CentreEquestreService]
    });
  });

  it('should be created', inject([CentreEquestreService], (service: CentreEquestreService) => {
    expect(service).toBeTruthy();
  }));
});
