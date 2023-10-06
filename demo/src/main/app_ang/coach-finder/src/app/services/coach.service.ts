import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coach } from '../model/Coach';

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

  registerCoach(coach: Object) {
    return this.httpClient.post<Coach>(this.BASE_URL, coach);
  }

  getFilteredCoaches(chosedAreas: string[]): Observable<Coach[]> {
    return this.httpClient.post<Coach[]>(this.BASE_URL + 'filter', chosedAreas);
  }
}
