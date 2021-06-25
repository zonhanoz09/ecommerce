import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user/user.model';
import {AppSettings} from '../../appSettings';

const baseUrl = AppSettings.API_ENDPOINT + 'api/admin/user';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    .append('Authorization', `Bearer ${'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxLGFkbWluIiwiaXNzIjoiZXhhbXBsZS5pbyIsImlhdCI6MTYyNDYzMDE0OSwiZXhwIjoxNjI1MjM0OTQ5fQ.5E0ggF0sIt4FsJqKyQUS2wao3qIooRsloxEF4Lv6YdPZdOx1MwyKdSzUU5nZWsS3sSNpgUkdaPz_cA7lYBrOMw'}`)
    // .append('Access-Control-Allow-Origin', '*')
    // .append('Access-Control-Allow-Methods', 'GET')
  };
  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(baseUrl,this.httpOptions);
  }

  get(id:number): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: User): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id:number, data:User): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

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
