import { Component, Input } from '@angular/core';
import { CoachRequest } from 'src/app/model/CoachRequest';

@Component({
  selector: 'app-request-card',
  templateUrl: './request-card.component.html',
  styleUrls: ['./request-card.component.css']
})
export class RequestCardComponent {

 @Input() request: CoachRequest;
}
