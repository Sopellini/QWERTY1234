import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../client';
import { ClientsService } from '../clients.service';



@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: Client[];
  selectedClient: Client;

  constructor(
    private router: Router,
    private clientsService: ClientsService
  ) { }

  ngOnInit() {
    this.getClients();
  }

  getClients(): void{
    this.clientsService.getClients().then(clients => this.clients = clients);
  }

  onSelect(client: Client): void{
    this.selectedClient = client;
  }

  goToDetail(): void{
    this.router.navigate(['/clientDetails', this.selectedClient.clientId]);
  }

}
