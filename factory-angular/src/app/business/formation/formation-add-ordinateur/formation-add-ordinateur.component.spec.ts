import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationAddOrdinateurComponent } from './formation-add-ordinateur.component';

describe('FormationAddOrdinateurComponent', () => {
  let component: FormationAddOrdinateurComponent;
  let fixture: ComponentFixture<FormationAddOrdinateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormationAddOrdinateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormationAddOrdinateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
