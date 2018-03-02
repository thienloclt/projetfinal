import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {GestionnaireListComponent} from './gestionnaire-list.component';



describe('GestionnaireListComponent', () => {
  let component: GestionnaireListComponent;
  let fixture: ComponentFixture<GestionnaireListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionnaireListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionnaireListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
