import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnseignementListComponent } from './enseignement-list.component';

describe('EnseignementListComponent', () => {
  let component: EnseignementListComponent;
  let fixture: ComponentFixture<EnseignementListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnseignementListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnseignementListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
