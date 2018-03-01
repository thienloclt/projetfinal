import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjecteurDetailComponent } from './projecteur-detail.component';

describe('ProjecteurDetailComponent', () => {
  let component: ProjecteurDetailComponent;
  let fixture: ComponentFixture<ProjecteurDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjecteurDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjecteurDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
