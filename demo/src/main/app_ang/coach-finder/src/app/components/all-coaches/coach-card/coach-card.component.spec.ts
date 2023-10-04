import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoachCardComponent } from './coach-card.component';

describe('CoachCardComponent', () => {
  let component: CoachCardComponent;
  let fixture: ComponentFixture<CoachCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CoachCardComponent]
    });
    fixture = TestBed.createComponent(CoachCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
