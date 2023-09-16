import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coach } from '../model/Coach';

@Injectable({
  providedIn: 'root',
})
export class CoachService {
  BASE_URL = '/private/api/coaches';
  constructor(private readonly httpClient: HttpClient) {}

  getAllCoaches(): Observable<Coach[]> {
    return this.httpClient.get<Coach[]>(this.BASE_URL + '/all');
  }

  registerCoach(coach: Coach) {
    return this.httpClient.post<Coach>(this.BASE_URL, coach);
  }

  getFilteredCoaches(chosedAreas: string[]): Observable<Coach[]> {
    return this.httpClient.post<Coach[]>(this.BASE_URL + 'filter', chosedAreas);
  }
}
