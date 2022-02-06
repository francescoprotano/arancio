import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminLoggedinComponent } from './admin-loggedin.component';

describe('AdminLoggedinComponent', () => {
  let component: AdminLoggedinComponent;
  let fixture: ComponentFixture<AdminLoggedinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminLoggedinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminLoggedinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
