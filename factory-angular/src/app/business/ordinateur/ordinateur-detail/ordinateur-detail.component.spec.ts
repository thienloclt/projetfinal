import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdinateurDetailComponent } from './ordinateur-detail.component';

describe('OrdinateurDetailComponent', () => {
  let component: OrdinateurDetailComponent;
  let fixture: ComponentFixture<OrdinateurDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrdinateurDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdinateurDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
