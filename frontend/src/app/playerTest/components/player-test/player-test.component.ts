import { Component, OnInit, AfterViewInit } from '@angular/core';
import { PlayerTestService } from '../../services/player-test-service/player-test.service';
import { Router } from '@angular/router';
import { MOVE_TYPES_PER_IMAGE } from '../../../shared/constants';
import { PlayerPreferences } from 'src/app/models/player-preferences.model';

@Component({
  selector: 'app-player-test',
  templateUrl: './player-test.component.html',
  styleUrls: ['./player-test.component.css']
})
export class PlayerTestComponent implements OnInit, AfterViewInit {
  moves: string[][] =  [];
  chosenMoveTypes: string[] = [];
  images: string[] = ['', '', '', ''];
  currIdx = 0;
  currImageSrc = '';
  currMoves: string[] = [];
  difficulties = ['beginner', 'intermediate', 'advanced'];
  seriousness = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  moveSelect: HTMLSelectElement;
  difficultySelect: HTMLSelectElement;
  seriousnessSelect: HTMLSelectElement;
  positionTime = false;

  constructor(private playerTestService: PlayerTestService, private router: Router) { }

  ngOnInit() {
    this.initializeMoves();

    this.currImageSrc = this.images[this.currIdx];
    this.currMoves = this.moves[this.currIdx];
  }

  initializeMoves() {
    let i = 0;
    for (let img of this.images) {
      img = img.substr(0, img.indexOf('.jpeg'));
      const imgSrcArr = img.split('/');
      this.moves[i] = imgSrcArr[imgSrcArr.length - 1].split('$');
      i++;
    }
  }

  ngAfterViewInit() {
    this.difficultySelect = (document.getElementById('difficultySelect') as HTMLSelectElement);
    this.seriousnessSelect = (document.getElementById('seriousnessSelect') as HTMLSelectElement);
  }

  goToNextStep() {
    if (!this.positionTime) {
      this.positionTime = true;
      const answers = [this.difficultySelect.textContent, this.seriousnessSelect.textContent];
      const pp = new PlayerPreferences();
      pp.playerDifficulty = this.difficultySelect.textContent.toUpperCase();
      pp.playerSeriousness = parseInt(this.seriousnessSelect.textContent, 10);
      pp.imgPaths = ['pos1', 'pos2', 'pos3', 'pos4'];
      this.playerTestService.sendAnswers(pp).subscribe((res: PlayerPreferences) => {
        this.images = res.imgPaths;
        this.initializeMoves();
        this.currImageSrc = this.images[0];
        this.currMoves = this.moves[0];
      });
      this.positionTime = true;
      setTimeout(() => {
        this.moveSelect = (document.getElementById('moveSelect') as HTMLSelectElement);
      }, 0);
      return;
    }
    const move = this.moveSelect.textContent;
    const idx = this.currMoves.findIndex(mv => mv === move);
    const imgSrcMoves = this.currImageSrc.split('/')[2].split('.')[0];
    this.chosenMoveTypes.push(MOVE_TYPES_PER_IMAGE[imgSrcMoves][idx]);
    if (document.getElementById('nextBtn').innerHTML !== 'Finish') {
      this.currIdx += 1;
      if (this.currIdx === this.images.length - 1) {
        document.getElementById('nextBtn').innerHTML = 'Finish';
      }
      this.currImageSrc = this.images[this.currIdx];
      this.currMoves = this.moves[this.currIdx];
    } else {
      this.playerTestService.sendMoves(this.chosenMoveTypes).subscribe((res: any) => {
        // localStorage.setItem('chosenMoveTypes', chosenMoveTypes.toString());
        localStorage.setItem('recommended', JSON.stringify(res));
        this.router.navigateByUrl('/');
      });
    }
  }

}
