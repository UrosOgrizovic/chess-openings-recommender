import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/shared/services/base.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


const ENDPOINTS = {
  SAVE_DRL_FILE: '/drlFile'
};

@Injectable({
  providedIn: 'root'
})
export class AddRuleService extends BaseService {

  constructor(private router: Router, private http: HttpClient) {
    super();
  }

  saveDRLFile(drlFile: any): Observable<any> {
    return this.http.post(`${this.baseUrl}${ENDPOINTS.SAVE_DRL_FILE}`, drlFile);
  }
}
