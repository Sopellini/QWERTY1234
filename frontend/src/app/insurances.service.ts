import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Insurance } from './insurance';

@Injectable()
export class InsurancesService {

  private insurancesUrl = '/api/insurances';

  constructor(private http: Http) { }


  getInsurances(): Promise<Insurance[]>{
    return this.http.get(this.insurancesUrl)
      .toPromise()
      .then(response => response.json() as Insurance[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
