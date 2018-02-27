import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChevalAddComponent } from './cheval-add.component';

describe('UserTestAddComponent', () => {
  let component: ChevalAddComponent;
  let fixture: ComponentFixture<ChevalAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChevalAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChevalAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
