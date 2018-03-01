import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleDetailComponent } from './salle-detail.component';

describe('SalleDetailComponent', () => {
  let component: SalleDetailComponent;
  let fixture: ComponentFixture<SalleDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalleDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
