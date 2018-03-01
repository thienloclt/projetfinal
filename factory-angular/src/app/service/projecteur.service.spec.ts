import { TestBed, inject } from '@angular/core/testing';

import { ProjecteurService } from './projecteur.service';

describe('ProjecteurService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProjecteurService]
    });
  });

  it('should be created', inject([ProjecteurService], (service: ProjecteurService) => {
    expect(service).toBeTruthy();
  }));
});
