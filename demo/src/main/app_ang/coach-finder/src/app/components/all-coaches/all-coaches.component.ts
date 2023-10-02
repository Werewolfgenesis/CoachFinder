import { Component, OnInit } from '@angular/core';
import { Coach } from 'src/app/model/Coach';
import { CoachService } from 'src/app/services/coach.service';

@Component({
  selector: 'app-all-coaches',
  templateUrl: './all-coaches.component.html',
  styleUrls: ['./all-coaches.component.css'],
})
export class AllCoachesComponent implements OnInit {
  allCoaches: Coach[] = [];
  constructor(private readonly service: CoachService) {}
  ngOnInit() {
    this.fetchCoaches();
  }

  fetchCoaches() {
    this.service.getAllCoaches().subscribe((response) => {
      if (response) {
        this.allCoaches = response;
      }
    });
  }
}
