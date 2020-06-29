import { Component, OnInit } from '@angular/core';
import { ChessGameService } from '../../../chess-game/services/chess-game-service/chess-game.service';
import { ToastrService } from 'ngx-toastr';


declare var ChessBoard: any;
const Chess = require('chess.js');

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {
  game: any;
  gameBoard: any;
  boardConfig = {
    draggable: false,
    position: 'start'
  };
  futureMoves = [];
  recommendedGamesDisplay = [];
  recommendedGames = [];
  selectedGameIdx: number;
  recommended: any;
  playerType = '';
  selectedOpeningIdx: number;
  selectedBookIdx: number;


  constructor(private chessGameService: ChessGameService,
              private toastr: ToastrService) { }

  ngOnInit() {
    if (localStorage.getItem('spamDetected') === 'true') {
      this.toastr.error('More than 5 tests requested in one hour', 'Spam detected');
    }
    this.recommended = JSON.parse(localStorage.getItem('recommended'));


    this.game = new Chess();
    this.gameBoard = ChessBoard('gameBoard', this.boardConfig);

    if (this.recommended) {
      for (let i = 0; i < this.recommended.openings.length; i++) {
        this.recommended.openings[i].openingName = this.escapeUnicodeChars(this.recommended.openings[i].openingName);
        this.recommended.openings[i].description = this.escapeUnicodeChars(this.recommended.openings[i].description);
      }

      this.recommendedGames = this.recommended.chessGames;
      this.fillGamesForDisplay();
      this.setGame(this.recommendedGames[0], 0);
      this.playerType = this.recommended.chessGames[0].gameType[0] + this.recommended.chessGames[0].gameType.substring(1).toLowerCase();
      this.selectedOpeningIdx = 0;
      this.selectedBookIdx = 0;
    } else {
      // display all games if test not yet completed
      this.chessGameService.findAll().subscribe((res: any) => {
        this.recommendedGames = res._embedded.chessGames.slice(0, 6);
        this.fillGamesForDisplay();
        this.setGame(this.recommendedGames[0], 0);
        this.selectedOpeningIdx = 0;
        this.selectedBookIdx = 0;
        document.getElementById('leftColumnDiv').style.width = '100%';
      });
    }
  }

  escapeUnicodeChars(txt) {
    return txt.replace(
      /\\u([0-9a-f]{4})/g, (whole, group1) => String.fromCharCode(parseInt(group1, 16))
    );
  }

  fillGamesForDisplay() {
    for (const cg of this.recommendedGames) {
      this.game.load_pgn(cg.pgn);
      const header = this.game.header();
      const whiteSurname = header.White.split(' ')[1];
      const blackSurname = header.Black.split(' ')[1];
      const toPush = whiteSurname + ' - ' + blackSurname + ' (' + header.Date.substring(0, 4) + ')';
      this.recommendedGamesDisplay.push(toPush);
    }
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
    this.gameBoard.position(this.game.fen());
  }

  previousMove() {
    // adds item to beginning of array
    this.futureMoves.unshift(this.game.undo());
    this.gameBoard.position(this.game.fen());
  }

  nextMove() {
    // removes first element of array
    this.game.move(this.futureMoves.shift());
    this.gameBoard.position(this.game.fen());
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
