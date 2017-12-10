import {Component, OnInit, TemplateRef} from '@angular/core';
import {ClientsService} from "../clients.service";
import {Client} from "../client";
import {EmailService} from "../email.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  clients: Client[];
  client: Client;
  display: boolean = false;

  constructor(
    private clientsService: ClientsService,
    private emailService: EmailService
  ) { }

  ngOnInit() {
    this.getClientBirthday();
  }

  getClientBirthday(): void{
    this.clientsService.getClientsBirthday().then(clients => this.clients = clients);
  }

  showDialog(client) {
    this.display = true;
    this.client = client;
  }

  sendEmail(){
    this.emailService.sendEmail();
  }

}
