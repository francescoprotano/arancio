import { TestBed } from '@angular/core/testing';

import { MeseService } from './mese.service';

describe('MeseService', () => {
  let service: MeseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MeseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
