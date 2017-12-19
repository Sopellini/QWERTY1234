import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {AddClientComponent} from "../add-client/add-client.component";
import {ClientsComponent} from '../clients/clients.component';
import {ClientDetailsComponent} from "../client-details/client-details.component";
import {InsurancesComponent} from "../insurances/insurances.component";
import {HomeComponent} from "../home/home.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'addClient', component: AddClientComponent},
  {path: 'clients', component: ClientsComponent},
  {path: 'clientDetails/:clientId', component: ClientDetailsComponent},
  {path: 'insurances', component: InsurancesComponent}
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
