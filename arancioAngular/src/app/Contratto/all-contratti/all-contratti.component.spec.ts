import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllContrattiComponent } from './all-contratti.component';

describe('AllContrattiComponent', () => {
  let component: AllContrattiComponent;
  let fixture: ComponentFixture<AllContrattiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllContrattiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllContrattiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
