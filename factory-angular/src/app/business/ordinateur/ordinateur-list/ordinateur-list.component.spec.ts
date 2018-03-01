import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdinateurListComponent } from './ordinateur-list.component';

describe('OrdinateurListComponent', () => {
  let component: OrdinateurListComponent;
  let fixture: ComponentFixture<OrdinateurListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrdinateurListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdinateurListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
