import { Area } from './Area';

export interface Coach {
  id: number;
  firstName: string;
  lastName: string;
  description: string | null;
  areas: Area[];
  rate: number;
  requests: [];
}
