import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjecteurListComponent } from './projecteur-list.component';

describe('ProjecteurListComponent', () => {
  let component: ProjecteurListComponent;
  let fixture: ComponentFixture<ProjecteurListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjecteurListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjecteurListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
