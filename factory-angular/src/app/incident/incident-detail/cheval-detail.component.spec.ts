import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChevalDetailComponent } from './cheval-detail.component';

describe('UserTestDetailComponent', () => {
  let component: ChevalDetailComponent;
  let fixture: ComponentFixture<ChevalDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChevalDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChevalDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
