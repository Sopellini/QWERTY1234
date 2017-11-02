import {Pipe, PipeTransform} from '@angular/core';

@Pipe({  name: 'insuranceOrderBy' })
export class InsuranceOrderPipe implements PipeTransform {

  transform(insurances: Array<any>, args?: any): any {

    return insurances.sort(function(a, b){
      if(a[args.property] < b[args.property]){
        return -1 * args.direction;
      }
      else if( a[args.property] > b[args.property]){
        return 1 * args.direction;
      }
      else{
        return 0;
      }
    });
  };
}
