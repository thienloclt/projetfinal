import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormateurDetailComponent } from './formateur-detail.component';

describe('FormateurDetailComponent', () => {
  let component: FormateurDetailComponent;
  let fixture: ComponentFixture<FormateurDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormateurDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormateurDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
