import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationAddProgrammeComponent } from './formation-add-programme.component';

describe('FormationAddProgrammeComponent', () => {
  let component: FormationAddProgrammeComponent;
  let fixture: ComponentFixture<FormationAddProgrammeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormationAddProgrammeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormationAddProgrammeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
