import { Component, OnInit } from '@angular/core';
// import * as Chess from 'chess.js';
// import { Chess } from 'chess.js';

declare var ChessBoard: any;
const Chess = require('chess.js');

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
  game: any;
  board: any;
  boardConfig = {
    draggable: true,
    position: 'start',
    onDragStart: this.onDragStart.bind(this),
    onDrop: this.onDrop.bind(this),
    onSnapEnd: this.onSnapEnd.bind(this)
  };
constructor() { }

ngOnInit() {
  this.game = new Chess();
  this.board = ChessBoard('board1', this.boardConfig);
  const pgn = [
      '[Event "Hoogovens Group A"]',
      '[Site "Wijk aan Zee NED"]',
      '[Date "1999.01.20"]',
      '[EventDate "1999.01.16"]',
      '[Round "4"]',
      '[Result "1-0"]',
      '[White "Garry Kasparov"]',
      '[Black "Veselin Topalov"]',
      '[ECO "B07"]',
      '[WhiteElo "2812"]',
      '[BlackElo "2700"]',
      '[PlyCount "87"]',
      '',
      '1. e4 d6 2. d4 Nf6 3. Nc3 g6 4. Be3 Bg7 5. Qd2 c6 6. f3 b5',
      '7. Nge2 Nbd7 8. Bh6 Bxh6 9. Qxh6 Bb7 10. a3 e5 11. O-O-O Qe7',
      '12. Kb1 a6 13. Nc1 O-O-O 14. Nb3 exd4 15. Rxd4 c5 16. Rd1 Nb6',
      '17. g3 Kb8 18. Na5 Ba8 19. Bh3 d5 20. Qf4+ Ka7 21. Rhe1 d4',
      '22. Nd5 Nbxd5 23. exd5 Qd6 24. Rxd4 cxd4 25. Re7+ Kb6',
      '26. Qxd4+ Kxa5 27. b4+ Ka4 28. Qc3 Qxd5 29. Ra7 Bb7 30. Rxb7',
      'Qc4 31. Qxf6 Kxa3 32. Qxa6+ Kxb4 33. c3+ Kxc3 34. Qa1+ Kd2',
      '35. Qb2+ Kd1 36. Bf1 Rd2 37. Rd7 Rxd7 38. Bxc4 bxc4 39. Qxh8',
      'Rd3 40. Qa8 c3 41. Qa4+ Ke1 42. f4 f5 43. Kc1 Rd2 44. Qa7 1-0'
      ];
  // this.game.load_pgn(pgn.join('\n'));
  // this.board.position(this.game.fen());
  if (localStorage.getItem('chosenMoveTypes')) {
      console.log(localStorage.getItem('chosenMoveTypes'));
    }
  }

  onDragStart(source, piece, position, orientation) {
    // do not pick up pieces if the game is over
    if (this.game.game_over()) { return false; }

    // only pick up pieces for the side to move
    if ((this.game.turn() === 'w' && piece.search(/^b/) !== -1) ||
        (this.game.turn() === 'b' && piece.search(/^w/) !== -1)) {
      return false;
    }
  }

  onDrop(source, target) {
    // see if the move is legal
    const move = this.game.move({
      from: source,
      to: target,
      promotion: 'q' // NOTE: always promote to a queen for example simplicity
    });

    // illegal move
    if (move === null) { return 'snapback'; }
  }

  // update the board position after the piece snap
  // for castling, en passant, pawn promotion
  onSnapEnd() {
    this.board.position(this.game.fen());
  }

}
