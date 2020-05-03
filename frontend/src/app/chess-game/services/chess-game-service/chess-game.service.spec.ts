import { TestBed } from '@angular/core/testing';

import { ChessGameService } from './chess-game.service';

describe('ChessGameService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ChessGameService = TestBed.get(ChessGameService);
    expect(service).toBeTruthy();
  });
});
