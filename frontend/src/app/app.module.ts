import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { AddClientComponent } from './add-client/add-client.component'
import { NavComponent } from './nav/nav.component';
import { ClientsComponent } from './clients/clients.component';
import { ClientsService } from './clients.service';
import { ClientDetailsComponent } from './client-details/client-details.component';
import { InsurancesComponent } from './insurances/insurances.component';
import {InsurancesService } from './insurances.service';
import {HomeComponent} from "./home/home.component";

import {AppRoutingModule} from './app-routing/app-routing.module';
import {DataTableModule, SharedModule, DataGridModule, DialogModule, ButtonModule} from "primeng/primeng";
import {NgDraggableWidgetModule} from "ngx-draggable-widget";
import {ModalModule} from "ngx-bootstrap";
import {EmailService} from "./email.service";


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    DataTableModule,
    SharedModule,
    DataGridModule,
    DialogModule,
    ButtonModule,
    NgDraggableWidgetModule,
    ModalModule
  ],
  declarations: [
    AppComponent,
    AddClientComponent,
    NavComponent,
    ClientsComponent,
    ClientDetailsComponent,
    InsurancesComponent,
    HomeComponent
  ],
  providers: [ClientsService, InsurancesService, EmailService],
  bootstrap: [AppComponent]
})
export class AppModule { }
