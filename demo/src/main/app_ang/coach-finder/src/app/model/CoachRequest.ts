import { Coach } from './Coach';

export interface CoachRequest {
  email: string;
  message: string;
  coach: Coach;
}
