import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Insurance} from "../insurance";
import {InsurancesService} from "../insurances.service";

@Component({
  selector: 'app-insurances',
  templateUrl: './insurances.component.html',
  styleUrls: ['./insurances.component.css']
})
export class InsurancesComponent implements OnInit {

  insurances: Insurance[];

  constructor(
    private router: Router,
    private insuranceService: InsurancesService
  ) { }

  ngOnInit() {
    this.getInsurances();
  }

  getInsurances(): void{
    this.insuranceService.getInsurances().then(insurances => this.insurances = insurances);
  }

}
