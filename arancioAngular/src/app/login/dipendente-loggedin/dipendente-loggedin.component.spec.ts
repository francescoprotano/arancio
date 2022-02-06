import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DipendenteLoggedinComponent } from './dipendente-loggedin.component';

describe('DipendenteLoggedinComponent', () => {
  let component: DipendenteLoggedinComponent;
  let fixture: ComponentFixture<DipendenteLoggedinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DipendenteLoggedinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DipendenteLoggedinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
