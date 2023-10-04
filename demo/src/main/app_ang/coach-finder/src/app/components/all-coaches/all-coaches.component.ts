import { Component, EventEmitter, OnInit } from '@angular/core';
import { Area } from 'src/app/model/Area';
import { Coach } from 'src/app/model/Coach';
import { AreasService } from 'src/app/services/areas.service';
import { CoachService } from 'src/app/services/coach.service';

@Component({
  selector: 'app-all-coaches',
  templateUrl: './all-coaches.component.html',
  styleUrls: ['./all-coaches.component.css'],
})
export class AllCoachesComponent implements OnInit {

  allCoaches: Coach[];
  allAreas: Area[];


  constructor(private readonly coachService: CoachService, private areasService: AreasService) {}
  ngOnInit() {
    this.fetchCoaches();
    this.fetchAreas();
  }

  fetchCoaches() {
    this.coachService.getAllCoaches().subscribe((response) => {
      if (response) {
        this.allCoaches = response;
      }
    });
  }

  fetchAreas() {
    this.areasService.getAllAreas().subscribe((response) => {
      if(response) {
        this.allAreas = response;
      }
    })
  }


  selectedFilter(checkbox: Event) {
    console.log(checkbox)
  }
}
