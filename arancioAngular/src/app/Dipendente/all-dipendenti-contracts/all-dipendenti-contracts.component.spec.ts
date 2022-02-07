import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllDipendentiContractsComponent } from './all-dipendenti-contracts.component';

describe('AllDipendentiContractsComponent', () => {
  let component: AllDipendentiContractsComponent;
  let fixture: ComponentFixture<AllDipendentiContractsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllDipendentiContractsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllDipendentiContractsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
