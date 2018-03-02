import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationAddStagiaireComponent } from './formation-add-stagiaire.component';

describe('FormationAddStagiaireComponent', () => {
  let component: FormationAddStagiaireComponent;
  let fixture: ComponentFixture<FormationAddStagiaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormationAddStagiaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormationAddStagiaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
