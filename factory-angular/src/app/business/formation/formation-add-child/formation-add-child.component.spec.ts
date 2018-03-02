import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationAddChildComponent } from './formation-add-child.component';

describe('FormationAddChildComponent', () => {
  let component: FormationAddChildComponent;
  let fixture: ComponentFixture<FormationAddChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormationAddChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormationAddChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
