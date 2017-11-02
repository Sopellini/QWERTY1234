import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'insuranceSearch'})
export class InsurancesSearchPipe implements PipeTransform{
  transform(insurances: any, searchText: any): any{
    if(searchText == null) return insurances;

    return insurances.filter(function (insurance) {
      return insurance.insuranceType.insuranceType.toLowerCase().indexOf(searchText.toLowerCase()) > -1;
    })
  }
}
