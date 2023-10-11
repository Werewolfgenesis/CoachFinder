import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Area } from 'src/app/model/Area';
import { AreasService } from 'src/app/services/areas.service';
import { CoachService } from 'src/app/services/coach.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  allAreas: Area[] = [];
  selectedCheckboxes: string[] = [];

  constructor(
    private readonly areasService: AreasService,
    private formBuilder: FormBuilder,
    private readonly coachService: CoachService,
    private router: Router
  ) {}

  profileForm = this.formBuilder.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    description: [''],
    rate: ['', [Validators.min(0), Validators.required]],
  });

  

  ngOnInit() {
    this.fetchAreas();
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
      this.selectedCheckboxes.pop();
    }
    console.log(this.selectedCheckboxes);
  }

  submitForm() {

    const coach: Object = {
      ...this.profileForm.value,
      areas: this.selectedCheckboxes,
    };
    
    this.coachService.registerCoach(coach).subscribe((res) => {
      this.router.navigate(['/all-coaches']);
    });
   
  }



}
