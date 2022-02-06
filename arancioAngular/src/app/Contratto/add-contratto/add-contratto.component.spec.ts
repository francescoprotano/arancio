import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddContrattoComponent } from './add-contratto.component';

describe('AddContrattoComponent', () => {
  let component: AddContrattoComponent;
  let fixture: ComponentFixture<AddContrattoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddContrattoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddContrattoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
