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
  currentCoaches: Coach[] = [];
  allAreas: Area[];


  hasItems: boolean = true;

  //FILTERS
  selectedCheckboxes: string[] = [];

  //PAGINATION
  currentPage = 1;
  selectedItemsPerPage: number;

  constructor(
    private readonly coachService: CoachService,
    private areasService: AreasService,
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


  filterCoaches() {
    this.coachService.getFilteredCoaches(this.selectedCheckboxes, this.currentPage-1, this.selectedItemsPerPage)
    .subscribe(response => {
      if(response) {  
       this.currentCoaches = response
      } 
    })
  }


  onPreviosPage() {
    if(this.currentPage !==1) {
      this.currentPage-=1;
      this.filterCoaches()
    }
  }

  onNextPage() {
      this.currentPage+=1;
 
      if(!this.selectedItemsPerPage) {
        this.selectedItemsPerPage = 3
        this.filterCoaches()
      }
      
        this.filterCoaches()

  }

  setItemsPerPage() {
    this.selectedItemsPerPage = this.selectedItemsPerPage;
    this.currentPage = 1;
    
  }



  onCheckboxChange(selected: Area, isChecked: boolean) {
    if (isChecked) {
      this.selectedCheckboxes.push(selected.code);
    } else {
      let startIndex = this.selectedCheckboxes.indexOf(selected.code)
      this.selectedCheckboxes.splice(startIndex, 1);
    }
  }

  onFilter() {

    if (this.selectedCheckboxes.length == 0 ) {
      this.currentCoaches = this.allCoaches;
      return
     }

     if(!this.selectedItemsPerPage) {
      this.selectedItemsPerPage = 3;
    }

    this.filterCoaches()
    return
      
  }
}
