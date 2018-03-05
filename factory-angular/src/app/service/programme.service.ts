import {Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Programme} from '../model/programme.model';

@Injectable()
export class ProgrammeService {

  url = 'http://localhost:8080/factory/api/programme/';

  constructor(private http: HttpClient) {
  }

  list(): Observable<any> {
    return this.http.get(this.url);
  }

  get(id: number): Observable<any> {
    return this.http.get(this.url + id);
  }

  add(obj: Programme): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.url, obj,  {headers});
  }

  update(obj: Programme): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.put(this.url, obj,  {headers});
  }

  delete(id: number): Observable<any> {
    return this.http.delete(this.url + id);
  }

  private handleError(error: any) {
    let errMsg = (error.message) ? error.message : error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
