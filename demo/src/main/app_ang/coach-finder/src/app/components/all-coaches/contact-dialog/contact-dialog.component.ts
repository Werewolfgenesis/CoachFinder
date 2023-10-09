import { Component, EventEmitter, Inject, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { CoachService } from 'src/app/services/coach.service';
import {MAT_DIALOG_DATA} from '@angular/material/dialog'
import { Coach } from 'src/app/model/Coach';

@Component({
  selector: 'app-contact-dialog',
  templateUrl: './contact-dialog.component.html',
  styleUrls: ['./contact-dialog.component.css']
})
export class ContactDialogComponent {


  constructor(private formBuilder: FormBuilder,
              private coachService: CoachService,
              @Inject(MAT_DIALOG_DATA) public data: {coach: Coach}){}
  
  contactForm = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    message: ['', Validators.required],

  });


  onSubmit() {
    console.log(this.contactForm.controls['message'].value);

    const request: Object = {
      ...this.contactForm.value,
      id: this.data.coach.id
    }

    console.log(request);
    
    this.coachService.addRequest(request).subscribe();
  }
}
