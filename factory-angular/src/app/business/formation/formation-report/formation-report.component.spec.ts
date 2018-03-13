import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationReportComponent } from './formation-report.component';

describe('FormationReportComponent', () => {
  let component: FormationReportComponent;
  let fixture: ComponentFixture<FormationReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormationReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormationReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
