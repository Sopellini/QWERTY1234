import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Client } from './client';


@Injectable()
export class ClientsService {

  private clientsUrl = '/api/clients';
  private clientsBirthdayUrl = '/api/clientBirthdays';
  private clientDetailsUrl = '/api/clientDetails';
  private headers = new Headers({'Content-Type':'application/json'});


  constructor(private http: Http) { }

  getClients(): Promise<Client[]>{
    return this.http.get(this.clientsUrl)
      .toPromise()
      .then(response => response.json() as Client[])
      .catch(this.handleError);
  }

  getClientsBirthday(): Promise<Client[]>{
    return this.http.get(this.clientsBirthdayUrl)
      .toPromise()
      .then(response => response.json() as Client[])
      .catch(this.handleError);
  }

  getClient(clientId: number): Promise<Client>{
    const url = `${this.clientDetailsUrl}/${clientId}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Client)
      .catch(this.handleError);
  }

  updateClient(client: Client):Promise<Client>{
    const url = `${this.clientDetailsUrl}/${client.clientId}`;
    return this.http
      .put(url, JSON.stringify(client), {headers: this.headers})
      .toPromise()
      .then(() => client)
      .catch(this.handleError);
  }

  createClient(client: Client):Promise<Client>{
    return this.http
      .post(this.clientsUrl, JSON.stringify(client), {headers: this.headers})
      .toPromise()
      .then(response => response.json() as Client)
      .catch(this.handleError);
  }

  deleteClient(clientId: number): Promise<Client>{
    const url = `${this.clientDetailsUrl}/${clientId}`;
    return this.http
      .delete(url, {headers: this.headers})
      .toPromise()
      .then(response => response.json() as Client)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
