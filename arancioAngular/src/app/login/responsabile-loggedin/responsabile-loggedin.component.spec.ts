import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsabileLoggedinComponent } from './responsabile-loggedin.component';

describe('ResponsabileLoggedinComponent', () => {
  let component: ResponsabileLoggedinComponent;
  let fixture: ComponentFixture<ResponsabileLoggedinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResponsabileLoggedinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResponsabileLoggedinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
