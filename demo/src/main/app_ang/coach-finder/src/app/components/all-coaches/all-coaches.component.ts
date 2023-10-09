import { Component, OnInit } from '@angular/core';
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
  currentCoaches: Coach[];
  allAreas: Area[];

  selectedCheckboxes: string[] = [];
  filteredCoaches: Set<Coach> = new Set();

  constructor(
    private readonly coachService: CoachService,
    private areasService: AreasService
  ) {}
  ngOnInit() {
    this.fetchCoaches();
    this.fetchAreas();
  }

  fetchCoaches() {
    this.coachService.getAllCoaches().subscribe((response) => {
      if (response) {
        this.allCoaches = response;
        this.currentCoaches = this.allCoaches;
      }
    });
  }

  fetchAreas() {
    this.areasService.getAllAreas().subscribe((response) => {
      if (response) {
        this.allAreas = response;
      }
    });
  }

  onCheckboxChange(selected: string, isChecked: boolean) {
    if (isChecked) {
      this.selectedCheckboxes.push(selected);
    } else {
      let startIndex = this.selectedCheckboxes.indexOf(selected)
      this.selectedCheckboxes.splice(startIndex, 1);
    }
  }

  onFilter() {

    if (this.selectedCheckboxes.length == 0) {
     return this.currentCoaches = this.allCoaches;
     }

      for (let coach of this.allCoaches) {
        if (coach.areas.some((ar) => this.selectedCheckboxes.includes(ar))) {
          this.filteredCoaches.add(coach);
        }
        else{
          this.filteredCoaches.delete(coach)
        }
      }
      
     this.currentCoaches = Array.from(this.filteredCoaches) 
     return this.currentCoaches;
      

  }
}
