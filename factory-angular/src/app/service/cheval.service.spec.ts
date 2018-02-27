import { TestBed, inject } from '@angular/core/testing';

import { UserTestService } from './cheval.service';

describe('UserTestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserTestService]
    });
  });

  it('should be created', inject([UserTestService], (service: UserTestService) => {
    expect(service).toBeTruthy();
  }));
});
