import { TestBed } from '@angular/core/testing';

import { DipendenteMeseService } from './dipendente-mese.service';

describe('DipendenteMeseService', () => {
  let service: DipendenteMeseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DipendenteMeseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
