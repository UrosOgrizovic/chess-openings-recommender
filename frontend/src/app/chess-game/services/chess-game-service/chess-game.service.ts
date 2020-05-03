import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BaseService } from 'src/app/shared/services/base.service';

const ENDPOINTS = {
  FIND_ALL: '/chessGames',
};

@Injectable({
  providedIn: 'root'
})
export class ChessGameService extends BaseService {
  constructor(private router: Router, private http: HttpClient) { super(); }

  findAll() {
    return this.http.get(`${this.baseUrl}${ENDPOINTS.FIND_ALL}`);
  }
}
