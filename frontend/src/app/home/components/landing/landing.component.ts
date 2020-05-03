import { Component, OnInit } from '@angular/core';
import { ChessGameService } from '../../../chess-game/services/chess-game-service/chess-game.service';
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
    draggable: false,
    position: 'start'
  };
  futureMoves = [];
  recommendedGamesDisplay = [];
  recommendedGames = [];
  selectedGameIdx: number;

  constructor(private chessGameService: ChessGameService) { }

  ngOnInit() {
    this.game = new Chess();
    this.board = ChessBoard('board1', this.boardConfig);

    // only for demonstration, will be replaced by games of certain type
    this.chessGameService.findAll().subscribe((res: any) => {
      this.recommendedGames = res._embedded.chessGames;
      for (const cg of this.recommendedGames) {
        this.game.load_pgn(cg.pgn);
        const header = this.game.header();
        const whiteSurname = header.White.split(' ')[1];
        const blackSurname = header.Black.split(' ')[1];
        const toPush = whiteSurname + ' - ' + blackSurname + ' (' + header.Date.substring(0, 4) + ')';
        this.recommendedGamesDisplay.push(toPush);
      }
      this.setGame(this.recommendedGames[0], 0);
    });
  }

  setGame(gameToSet: any, idx: number) {
    this.selectedGameIdx = idx;
    this.game.load_pgn(gameToSet.pgn);
    const header = this.game.header();
    document.getElementById('white').innerHTML = header.White + ' (' + header.WhiteElo + ') ';
    document.getElementById('black').innerHTML = header.Black + ' (' + header.BlackElo + ') ';
    document.getElementById('gameResult').innerHTML = header.Result + ' ';
    document.getElementById('event').innerHTML = header.Event + ' ';
    document.getElementById('site').innerHTML = header.Site + ' ';
    document.getElementById('date').innerHTML = header.Date + ' ';

    this.goToBeginningOfGame();

  }

  goToBeginningOfGame() {
    const len = this.game.history().length;
    let i = 0;
    while (i < len) {
      // adds item to beginning of array
      this.futureMoves.unshift(this.game.undo());
      i++;
    }
    this.board.position(this.game.fen());
  }

  previousMove() {
    // adds item to beginning of array
    this.futureMoves.unshift(this.game.undo());
    this.board.position(this.game.fen());
  }

  nextMove() {
    // removes first element of array
    this.game.move(this.futureMoves.shift());
    this.board.position(this.game.fen());
  }

  displaySelectedGame(currRecGame: any, e: any) {
    const whiteSurnameCRG = currRecGame.split(' ')[0];
    const blackSurnameCRG = currRecGame.split(' ')[2].split('(')[0];
    for (let i = 0; i < this.recommendedGamesDisplay.length; i++) {
      if (this.recommendedGamesDisplay[i].includes(whiteSurnameCRG) &&
      this.recommendedGamesDisplay[i].includes(blackSurnameCRG)) {
        this.setGame(this.recommendedGames[i], parseInt(e.target.id.substring(e.target.id.length - 1), 10));
      }
    }
  }

}
