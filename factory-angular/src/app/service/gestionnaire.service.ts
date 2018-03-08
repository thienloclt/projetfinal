
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Gestionnaire} from '../model/gestionnaire.model';

@Injectable()
export class GestionnaireService {

  url = 'http://localhost:8080/factory/api/gestionnaire/';

  constructor(private http: HttpClient) {
  }

  list(): Observable<any> {
    return this.http.get(this.url);
  }

  get(id: number): Observable<any> {
    return this.http.get(this.url + id);
  }

  add(obj: Gestionnaire): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.url, obj,  {headers});
  }

  update(obj: Gestionnaire): Observable<any> {
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
