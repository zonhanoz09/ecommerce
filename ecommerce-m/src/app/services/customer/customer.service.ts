import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user/user.model';
import {AppSettings} from '../../appSettings';
import { environment } from '../../../environments/environment';

const baseUrl = environment.apiUrl + '/api/admin/user';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(baseUrl);
  }

  get(id:number): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: User): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  // update(id:number, data:User): Observable<any> {
  //   return this.http.put(`${baseUrl}/${id}`, data);
  // }

  delete(id:number): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByTitle(title:string): Observable<any> {
    return this.http.get(`${baseUrl}?title=${title}`);
  }
}
