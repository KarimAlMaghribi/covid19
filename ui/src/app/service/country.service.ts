
import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { catchError, retry, tap, map } from 'rxjs/operators';
import { Country } from './country';
import { environment } from './environment';

 
@Injectable({
 providedIn: 'root',
})
export class CountryService {
 
 private countriesUrl = `${environment.backendServer}/countries`;
 
 //private favoritesUrl = `${environment.backendServer}/favorites`;
 
 constructor(private http: HttpClient) { }
 
 getCountries(): Observable<Country[]> {
 
 return this.http
  .get<Country[]>(this.countriesUrl)

 
 }
 /*
 getFavorites(): Observable<string[]> {
 
 return this.http.get<string[]>(this.favoritesUrl);
 }
 
 deleteCountry(country: string): Observable<string> {
 
 return this.http.delete<string>(this.favoritesUrl + '/' + country);
 }
 
 postCountryToFavorites(country: string): Observable<string> {
 return this.http.post<string>(this.favoritesUrl + '/' + country, null);
 }
 */
 // private handleError<T>(operation = 'operation', result?: T) {
 // return (error: any): Observable<T> => {
 
 // // TODO: send the error to remote logging infrastructure
 // console.error(error); // log to console instead
 
 // // TODO: better job of transforming error for user consumption
 // this.log(`${operation} failed: ${error.message}`);
 
 // // Let the app keep running by returning an empty result.
 // return of(result as T);
 // };
 // }
 
 // private log(message: string) {
 // console.log(message);
 // //this.messageService.add(`HeroService: ${message}`);
 // }
 
}