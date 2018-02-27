import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTestDetailComponent } from './usertest-detail.component';

describe('UserTestDetailComponent', () => {
  let component: UserTestDetailComponent;
  let fixture: ComponentFixture<UserTestDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTestDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTestDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
