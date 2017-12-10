import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class EmailService {

  private sendEmailUrl = '/api/sendEmail';

  constructor(private http: Http) { }

  sendEmail(): Promise<any>{
    return this.http.request(this.sendEmailUrl)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
