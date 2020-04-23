import { TestBed } from '@angular/core/testing';

import { PlayerTestService } from './player-test.service';

describe('PlayerTestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlayerTestService = TestBed.get(PlayerTestService);
    expect(service).toBeTruthy();
  });
});
