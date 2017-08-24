import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {ClientsComponent} from '../clients/clients.component';
import {ClientDetailsComponent} from "../client-details/client-details.component";
import {InsurancesComponent} from "../insurances/insurances.component";

const routes: Routes = [
  {path: 'clients', component: ClientsComponent},
  {path: 'clientDetails/:client_id', component: ClientDetailsComponent},
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
