import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnseignementDetailComponent } from './enseignement-detail.component';

describe('EnseignementDetailComponent', () => {
  let component: EnseignementDetailComponent;
  let fixture: ComponentFixture<EnseignementDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnseignementDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnseignementDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
