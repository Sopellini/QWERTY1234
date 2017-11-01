import { InsuranceType } from './insuranceType';
import {Client} from "./client";

export class Insurance{
public id: number;
public startDate: string;
public endDate: string;
public insuranceType: InsuranceType;
public client: Client;
}
