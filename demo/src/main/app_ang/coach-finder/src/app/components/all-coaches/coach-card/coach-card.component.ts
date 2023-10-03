import { Component, Input, OnInit } from '@angular/core';
import { Coach } from 'src/app/model/Coach';


@Component({
  selector: 'app-coach-card',
  templateUrl: './coach-card.component.html',
  styleUrls: ['./coach-card.component.css'],
})
export class CoachCardComponent implements OnInit{
@Input() coach: Coach;

ngOnInit() {
  
}
}
