import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllDipendentiComponent } from './all-dipendenti.component';

describe('AllDipendentiComponent', () => {
  let component: AllDipendentiComponent;
  let fixture: ComponentFixture<AllDipendentiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllDipendentiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllDipendentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
