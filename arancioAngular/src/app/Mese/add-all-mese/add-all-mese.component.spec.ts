import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMeseComponent } from './add-all-mese.component';

describe('AddMeseComponent', () => {
  let component: AddMeseComponent;
  let fixture: ComponentFixture<AddMeseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddMeseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMeseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
