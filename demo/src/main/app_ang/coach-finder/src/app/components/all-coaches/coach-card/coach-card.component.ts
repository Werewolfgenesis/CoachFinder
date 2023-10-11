import { Component, Input, OnInit, Output, ViewChild } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Coach } from 'src/app/model/Coach';
import { ContactDialogComponent } from '../contact-dialog/contact-dialog.component';



@Component({
  selector: 'app-coach-card',
  templateUrl: './coach-card.component.html',
  styleUrls: ['./coach-card.component.css'],
})



export class CoachCardComponent implements OnInit{
@Input() coach: Coach;


constructor(public dialog: MatDialog){
}

ngOnInit() {
  
}

openDialog() {
  const dialogRef = this.dialog.open(
    ContactDialogComponent, {
      data: {
        coach: this.coach
      }
    });

  dialogRef.afterClosed().subscribe(result => {
    console.log(`Dialog result: ${result}`);
  });
}

}
