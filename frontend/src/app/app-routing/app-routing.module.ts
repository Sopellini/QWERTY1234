import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import {ClientsComponent} from '../clients/clients.component';
import {ClientDetailsComponent} from "../client-details/client-details.component";

const routes: Routes = [
  {path: 'clients', component: ClientsComponent},
  {path: 'clientDetails/:client_id', component: ClientDetailsComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
