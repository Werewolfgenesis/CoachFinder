import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Area } from '../model/Area';

@Injectable({
    providedIn: 'root',
  })
  export class AreasService {
    BASE_URL = '/private/api/areas';
    constructor(private readonly httpClient: HttpClient) {}

    getAllAreas(): Observable<Area[]> {
        return this.httpClient.get<Area[]>(this.BASE_URL);
    }
  }