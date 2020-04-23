import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BaseService } from 'src/app/shared/services/base.service';
import { Observable } from 'rxjs';

const ENDPOINTS = {
  SEND_MOVES: '/playerType/sendMoves',
};


@Injectable({
  providedIn: 'root'
})
export class PlayerTestService extends BaseService {

  constructor(private router: Router, private http: HttpClient) {
    super();
   }

  sendMoves(chosenMoves: string[]): Observable<any> {
    console.log(`${this.baseUrl}${ENDPOINTS.SEND_MOVES}`);
    return this.http.post(`${this.baseUrl}${ENDPOINTS.SEND_MOVES}`, chosenMoves);
  }
}
