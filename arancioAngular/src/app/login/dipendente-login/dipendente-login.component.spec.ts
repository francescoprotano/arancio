import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DipendenteLoginComponent } from './dipendente-login.component';

describe('DipendenteLoginComponent', () => {
  let component: DipendenteLoginComponent;
  let fixture: ComponentFixture<DipendenteLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DipendenteLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DipendenteLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
