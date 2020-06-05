import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BaseService } from 'src/app/shared/services/base.service';
import { Observable } from 'rxjs';
import { PlayerPreferences } from 'src/app/models/player-preferences.model';
import { DeterminePlayerType } from 'src/app/models/determine-player-type.model';

const ENDPOINTS = {
  SEND_MOVES: '/playerType/sendMoves',
  SEND_ANSWERS: '/playerType/sendAnswers'
};


@Injectable({
  providedIn: 'root'
})
export class PlayerTestService extends BaseService {

  constructor(private router: Router, private http: HttpClient) {
    super();
   }

  sendAnswers(playerPreferences: PlayerPreferences): Observable<any> {
    return this.http.post(`${this.baseUrl}${ENDPOINTS.SEND_ANSWERS}`, playerPreferences);
  }

  sendMoves(determinePlayerType: DeterminePlayerType): Observable<any> {
    return this.http.post(`${this.baseUrl}${ENDPOINTS.SEND_MOVES}`, determinePlayerType);
  }
}
