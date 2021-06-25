import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Product } from 'src/app/models/product/product.model';
import {AppSettings} from '../../appSettings';

@Injectable({providedIn: 'root'})
export class ProductService {

  private productUrl = AppSettings.API_ENDPOINT + 'product';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    .append('Access-Control-Allow-Headers', 'Content-Type')
    .append('Access-Control-Allow-Origin', '*')
  };
  
  constructor(
    private http: HttpClient)
   {}

 /** GET users from the server */
  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl)
      .pipe(
        tap(),
        catchError(this.handleError<Product[]>('getproducts', []))
      );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
   private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
