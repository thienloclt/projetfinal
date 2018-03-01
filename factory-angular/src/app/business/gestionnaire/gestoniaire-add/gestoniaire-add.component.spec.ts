import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestoniaireAddComponent } from './gestoniaire-add.component';

describe('GestoniaireAddComponent', () => {
  let component: GestoniaireAddComponent;
  let fixture: ComponentFixture<GestoniaireAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestoniaireAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestoniaireAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
