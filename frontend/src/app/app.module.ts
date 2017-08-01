import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { ClientsComponent } from './clients/clients.component';
import { ClientsService } from './clients.service';
import { ClientDetailsComponent } from './client-details/client-details.component';

import {AppRoutingModule} from './app-routing/app-routing.module';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    ClientsComponent,
    ClientDetailsComponent
  ],
  providers: [ClientsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
