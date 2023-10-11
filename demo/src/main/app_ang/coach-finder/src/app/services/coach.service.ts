import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coach } from '../model/Coach';
import { CoachRequest } from '../model/CoachRequest';

// export type RegisterObject = {
//   firstName: string,
//   lastName: string,
//   rate: number,
//   description: string,
//   areas: string[],
//   password: string
// }

@Injectable({
  providedIn: 'root',
})
export class CoachService {
  BASE_URL = '/private/api/coaches';
  constructor(private readonly httpClient: HttpClient) {}

  getAllCoaches(): Observable<Coach[]> {
    return this.httpClient.get<Coach[]>(this.BASE_URL + '/all');
  }

  indexAll(page: number, limit: number): Observable<Coach[]> {
    let params = new HttpParams();

    params = params.append('page', String(page));
    params = params.append('limit', String(limit));

    return this.httpClient.get<Coach[]>(this.BASE_URL + '/all', {params});
  }
  
  getFilteredCoaches(chosedAreas: string[]): Observable<Coach[]> {
    return this.httpClient.post<Coach[]>(this.BASE_URL + 'filter', chosedAreas);
  }
// TODO: types for object
  registerCoach(coach: Object) {
    return this.httpClient.post<Coach>(this.BASE_URL, coach);
  }
// TODO: types for object
  addRequest(request: Object) {
    return this.httpClient.post<Object>(this.BASE_URL + '/add-request', request);
  }
}
