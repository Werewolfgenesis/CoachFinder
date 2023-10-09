import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { CoachRequest } from "../model/CoachRequest";



@Injectable({
    providedIn: 'root',
  })
  export class RequestsService {
    BASE_URL = '/private/api/requests';
    constructor(private readonly httpClient: HttpClient) {}

    getAllRequests(): Observable<CoachRequest[]> {
        return this.httpClient.get<CoachRequest[]>(this.BASE_URL);
    }
  }