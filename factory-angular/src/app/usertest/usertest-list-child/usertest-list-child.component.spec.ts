import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTestListChildComponent } from './usertest-list-child.component';

describe('UserTestListChildComponent', () => {
  let component: UserTestListChildComponent;
  let fixture: ComponentFixture<UserTestListChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTestListChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTestListChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
