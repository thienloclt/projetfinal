import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import {FormationAddMaterielComponent} from './formation-add-materiel.component';

describe('FormationAddMaterielComponent', () => {
  let component: FormationAddMaterielComponent;
  let fixture: ComponentFixture<FormationAddMaterielComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormationAddMaterielComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormationAddMaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
