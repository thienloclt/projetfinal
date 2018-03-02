import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestoniaireDetailComponent } from './gestionnaire-detail.component';

describe('GestoniaireDetailComponent', () => {
  let component: GestoniaireDetailComponent;
  let fixture: ComponentFixture<GestoniaireDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestoniaireDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestoniaireDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
