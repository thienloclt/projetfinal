import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnseignementAddComponent } from './enseignement-add.component';

describe('EnseignementAddComponent', () => {
  let component: EnseignementAddComponent;
  let fixture: ComponentFixture<EnseignementAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnseignementAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnseignementAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
