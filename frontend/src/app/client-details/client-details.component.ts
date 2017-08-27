import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import 'rxjs/add/operator/switchMap';

import { ClientsService } from '../clients.service';
import { Client } from '../client';

@Component({
  selector: 'app-client-details',
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.css']
})
export class ClientDetailsComponent implements OnInit{

  client: Client;

  constructor(
    private clientService: ClientsService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void{
    this.route.paramMap
      .switchMap((params: ParamMap) => this.clientService.getClient(+params.get('client_id')))
      .subscribe(client => this.client = client);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.clientService.updateClient(this.client)
      .then(() => this.goBack());
  }

}
