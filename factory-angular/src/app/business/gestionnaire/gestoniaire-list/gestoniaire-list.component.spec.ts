import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestoniaireListComponent } from './gestoniaire-list.component';

describe('GestoniaireListComponent', () => {
  let component: GestoniaireListComponent;
  let fixture: ComponentFixture<GestoniaireListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestoniaireListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestoniaireListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
