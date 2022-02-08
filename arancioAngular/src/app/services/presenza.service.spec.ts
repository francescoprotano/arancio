import { TestBed } from '@angular/core/testing';

import { PresenzaService } from './presenza.service';

describe('PresenzaService', () => {
  let service: PresenzaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PresenzaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
