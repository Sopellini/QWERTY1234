import { Component, OnInit } from '@angular/core';
import {Insurance} from "../insurance";
import {InsurancesService} from "../insurances.service";

@Component({
  selector: 'app-insurances',
  templateUrl: './insurances.component.html',
  styleUrls: ['./insurances.component.css']
})
export class InsurancesComponent implements OnInit {

  insurances: Insurance[];
  loading: boolean;
  cols: any[];

  constructor(
    private insuranceService: InsurancesService
  ) { }

  ngOnInit() {
    this.loading = true;
    setTimeout(() => {
      this.getInsurances();
      this.loading = false;
      this.cols = [
        {field: 'id', header: 'ID'},
        {field: 'startDate', header: 'Data rozpoczęcia'},
        {field: 'endDate', header: 'Data końca'},
        {field: 'insuranceType.insuranceType', header: 'Rodzaj polisy'},
        {field: 'insuranceType.insuranceAmount', header: 'Suma ubezpieczenia'},
        {field: 'insuranceType.cost', header: 'Składka'},
        {field: 'insuranceType.paymentType', header: 'Rodzaj płatności'}
      ];
    }, 1000);
  }

  getInsurances(): void{
    this.insuranceService.getInsurances().then(insurances => this.insurances = insurances);
  }

}
