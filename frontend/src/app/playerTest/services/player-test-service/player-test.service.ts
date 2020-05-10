import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  sendMoves(chosenMoveTypes: string[]): Observable<any> {
    console.log(chosenMoveTypes);
    // return this.http.post(`${this.baseUrl}${ENDPOINTS.SEND_MOVES}`, chosenMoveTypes, {responseType: 'text'});
    return this.http.post(`${this.baseUrl}${ENDPOINTS.SEND_MOVES}`, chosenMoveTypes);
  }
}
