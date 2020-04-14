import { Component, OnInit } from '@angular/core';
import { PlayerTestService } from '../../services/player-test-service/player-test.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-player-test',
  templateUrl: './player-test.component.html',
  styleUrls: ['./player-test.component.css']
})
export class PlayerTestComponent implements OnInit {
  moves: string[][] =  [];
  chosenMoves: string[] = [];
  images: string[] = ['assets/positions/exf4$d5$Bc5.jpeg', 'assets/positions/Nf3$Qxd4$c3.jpeg',
                          'assets/positions/Ng5$d3$O-O.jpeg', 'assets/positions/Qa4$b4.jpeg'];
  currIdx = 0;
  currImageSrc = '';
  currMoves: string[] = [];
  moveSelect: HTMLSelectElement;

  constructor(private playerTestService: PlayerTestService, private router: Router) { }

  ngOnInit() {
    for (let img of this.images) {
      img = img.substr(0, img.indexOf('.jpeg'));
      const imgSrcArr = img.split('/');
      this.moves.push(imgSrcArr[imgSrcArr.length - 1].split('$')) ;
    }

    this.currImageSrc = this.images[this.currIdx];
    this.currMoves = this.moves[this.currIdx];
    this.moveSelect = (document.getElementById('moveSelect') as HTMLSelectElement);
  }

  goToNextStep() {
    this.chosenMoves.push(this.moveSelect.textContent);
    if (document.getElementById('nextBtn').innerHTML !== 'Finish') {
      this.currIdx += 1;
      if (this.currIdx === this.images.length - 1) {
        document.getElementById('nextBtn').innerHTML = 'Finish';
      }
      this.currImageSrc = this.images[this.currIdx];
      this.currMoves = this.moves[this.currIdx];
    } else {
      this.playerTestService.sendMoves(this.chosenMoves).subscribe((chosenMoves: string[]) => {
        localStorage.setItem('chosenMoves', chosenMoves.toString());
        this.router.navigateByUrl('/');
      });
    }
  }

}
