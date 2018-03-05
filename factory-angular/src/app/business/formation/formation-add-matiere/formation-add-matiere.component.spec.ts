import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationAddMatiereComponent } from './formation-add-matiere.component';

describe('FormationAddMatiereComponent', () => {
  let component: FormationAddMatiereComponent;
  let fixture: ComponentFixture<FormationAddMatiereComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormationAddMatiereComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormationAddMatiereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
