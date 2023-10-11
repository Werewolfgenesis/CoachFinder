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


  //FILTERS
  selectedCheckboxes: string[] = [];
  filteredCoaches: Set<Coach> = new Set();


  //PAGINATION
  numOfTotalPages: number;
  pages: number[];
 
  itemsPerpage = 3;
  currentPage = 1;
  indexOfLastItem = this.itemsPerpage;
  indexOfFirstItem = 0;

  visibleItems: Coach[];
  selectedItemsPerPage: number = 3;

  constructor(
    private readonly coachService: CoachService,
    private areasService: AreasService,
    ) {}
    
    
    ngOnInit() {
      this.fetchCoaches();
      this.fetchAreas();

  }

  onPagination() {

    this.numOfTotalPages = Math.ceil(this.currentCoaches.length/this.itemsPerpage)
    this.pages = [...Array(this.numOfTotalPages + 1).keys()].slice(1)

    this.indexOfLastItem = this.currentPage * this.itemsPerpage;
    this.indexOfFirstItem = this.indexOfLastItem - this.itemsPerpage;
    this.visibleItems = this.currentCoaches.slice(this.indexOfFirstItem, this.indexOfLastItem)
  }
  

  onPageClick(page: number) {
    
    this.currentPage = page;

    this.onPagination()

  }

  onPreviosPage() {
    if(this.currentPage !==1) {
      this.currentPage-=1;
      this.onPagination()
    }
  }

  onNextPage() {
    if(this.currentPage < this.numOfTotalPages) {
      this.currentPage+=1;
      this.onPagination()
    }
  }

  setItemsPerPage() {
    this.itemsPerpage = this.selectedItemsPerPage;
    this.currentPage = 1;
    this.onPagination()
    
  }


  fetchCoaches() {
    this.coachService.getAllCoaches().subscribe((response) => {
      if (response) {
        this.allCoaches = response;
        this.currentCoaches = this.allCoaches;
        this.onPagination()
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

      this.currentCoaches = this.allCoaches;
      this.onPagination()
      return
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
      this.onPagination()
      return
  }
}
