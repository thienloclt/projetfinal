import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleAvailableReportComponent } from './salle-available-report.component';

describe('SalleAvailableReportComponent', () => {
  let component: SalleAvailableReportComponent;
  let fixture: ComponentFixture<SalleAvailableReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalleAvailableReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleAvailableReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
