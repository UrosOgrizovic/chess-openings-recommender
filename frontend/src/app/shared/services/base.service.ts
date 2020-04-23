import { Injectable } from '@angular/core';
import { config } from '../config';

@Injectable({
  providedIn: 'root'
})
export class BaseService {
  baseUrl: string;
  constructor() {
    this.baseUrl = config.getApiUrl();
   }
}
