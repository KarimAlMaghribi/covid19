import { Observable } from 'rxjs';

export class Country {
  country: string;
    countryCode: string;
    slug: string;
    newConfirmed: number;
    totalConfirmed: number;
    newDeaths: number;
    totalDeaths: number;
    newRecovered: number;
    totalRecovered: number;
    date: Date;
  constructor( country: string,
    countryCode: string,
    slug: string,
    newConfirmed: number,
    totalConfirmed: number,
    newDeaths: number,
    totalDeaths: number,
    newRecovered: number,
    totalRecovered: number,
    date: Date){country= this.country; countryCode = this.countryCode; slug = this.slug; newConfirmed = this.newConfirmed; totalConfirmed = this.totalConfirmed; 
      newDeaths = this.newDeaths, totalDeaths = this.totalDeaths; newRecovered = this.newRecovered; totalRecovered = this.totalRecovered, date = this.date}
   
}

export abstract class CountryData {
  abstract getCountries(): Observable<Country[]>;
}
