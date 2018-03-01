import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjecteurAddComponent } from './projecteur-add.component';

describe('ProjecteurAddComponent', () => {
  let component: ProjecteurAddComponent;
  let fixture: ComponentFixture<ProjecteurAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjecteurAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjecteurAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
