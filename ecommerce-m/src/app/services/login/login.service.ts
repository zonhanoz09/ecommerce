import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { User } from 'src/app/models/user/user.model';
import { MessageService } from '../../message.service';
import { UserLogin } from 'src/app/models/user/user-login.model';
import {AppSettings} from '../../appSettings';

@Injectable({providedIn: 'root'})
export class LoginService {

  private userUrl = AppSettings.API_ENDPOINT + 'user';  // URL to web api
  private userUrlLogin = AppSettings.API_ENDPOINT + 'user/login';  // URL login

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    .append('Access-Control-Allow-Headers', 'Content-Type')
    .append('Access-Control-Allow-Origin', '*')
    // .append('Access-Control-Allow-Methods', 'GET')
  };
  
  constructor(
    private http: HttpClient,
    private messageService: MessageService  )
   {}

 /** GET users from the server */
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl)
      .pipe(
        tap(_ => this.log('fetched users')),
        catchError(this.handleError<User[]>('getUsers', []))
      );
  }

  //////// Save methods //////////

  /** POST: add a new hero to the server */
  login(userLogin: UserLogin): Observable<User> {
    return this.http.post<User>(this.userUrlLogin, userLogin, this.httpOptions).pipe(
      tap((newUser: User) => this.log(`login hero w/ id=${newUser.id}`)),
      catchError(this.handleError<User>('loginUser'))
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

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

   /** Log a HeroService message with the MessageService */
   private log(message: string) {
    this.messageService.add(`UserService: ${message}`);
  }
}
