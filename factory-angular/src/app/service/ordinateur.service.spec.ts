import { TestBed, inject } from '@angular/core/testing';

import { OrdinateurService } from './ordinateur.service';

describe('OrdinateurService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OrdinateurService]
    });
  });

  it('should be created', inject([OrdinateurService], (service: OrdinateurService) => {
    expect(service).toBeTruthy();
  }));
});
