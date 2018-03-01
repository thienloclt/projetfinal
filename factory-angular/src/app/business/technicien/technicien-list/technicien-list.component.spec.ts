import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TechnicienListComponent } from './technicien-list.component';

describe('TechnicienListComponent', () => {
  let component: TechnicienListComponent;
  let fixture: ComponentFixture<TechnicienListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TechnicienListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TechnicienListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
