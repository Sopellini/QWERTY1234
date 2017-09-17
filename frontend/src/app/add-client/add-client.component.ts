import { Component, OnInit } from '@angular/core';
import {Client} from "../client";
import {ClientsService} from "../clients.service";
import { Location } from '@angular/common';
import {Contact} from "../contact";

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  contact = new Contact();
  client = new Client();

  constructor(
    public clientService: ClientsService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.client.contact = this.contact;
  }

  create(): void {
    this.clientService.createClient(this.client)
      .then(() => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }
}
