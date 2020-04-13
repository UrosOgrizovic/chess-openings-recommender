import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-player-test',
  templateUrl: './player-test.component.html',
  styleUrls: ['./player-test.component.css']
})
export class PlayerTestComponent implements OnInit {
  moves: Array<string> =  [];

  constructor() { }

  ngOnInit() {
    var imgFullSrc = document.getElementById('currPos').getAttribute('src');
    imgFullSrc = imgFullSrc.substr(0, imgFullSrc.indexOf(".jpeg"));
    var imgSrcArr = imgFullSrc.split("/");
    this.moves = imgSrcArr[imgSrcArr.length - 1].split("-");

    console.log(this.moves);
  }

}
