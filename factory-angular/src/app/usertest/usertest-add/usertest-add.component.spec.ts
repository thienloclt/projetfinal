import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTestAddComponent } from './usertest-add.component';

describe('UserTestAddComponent', () => {
  let component: UserTestAddComponent;
  let fixture: ComponentFixture<UserTestAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTestAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTestAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
