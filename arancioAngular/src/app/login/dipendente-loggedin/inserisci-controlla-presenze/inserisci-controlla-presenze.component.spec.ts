import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InserisciControllaPresenzeComponent } from './inserisci-controlla-presenze.component';

describe('InserisciControllaPresenzeComponent', () => {
  let component: InserisciControllaPresenzeComponent;
  let fixture: ComponentFixture<InserisciControllaPresenzeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InserisciControllaPresenzeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InserisciControllaPresenzeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
