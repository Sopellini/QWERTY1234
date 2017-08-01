import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Client } from './client';


@Injectable()
export class ClientsService {

  private clientsUrl = '/api/clients';
  private clientDetailsUrl = '/api/clientDetails';

  constructor(private http: Http) { }

  getClients(): Promise<Client[]>{
    return this.http.get(this.clientsUrl)
      .toPromise()
      .then(response => response.json() as Client[])
      .catch(this.handleError);
  }

  getClient(client_id: number): Promise<Client>{
    const url = `${this.clientDetailsUrl}/${client_id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Client)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
