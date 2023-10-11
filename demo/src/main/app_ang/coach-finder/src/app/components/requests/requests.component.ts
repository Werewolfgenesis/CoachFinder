import { Component, OnInit } from '@angular/core';
import { CoachRequest } from 'src/app/model/CoachRequest';
import { RequestsService } from 'src/app/services/requests.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit{

  allRequests: CoachRequest[];

  constructor(private requestService: RequestsService) {}

  ngOnInit() {
    this.fetchAllRequests()
  }

  fetchAllRequests() {
     this.requestService.getAllRequests().subscribe((response) => {
      if (response) {
        this.allRequests = response;
      }
    });
  }

}
