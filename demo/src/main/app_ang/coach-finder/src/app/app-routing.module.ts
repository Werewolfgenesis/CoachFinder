import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllCoachesComponent } from './components/all-coaches/all-coaches.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'all-coaches',
    pathMatch: 'full',
  },
  {
    path: 'all-coaches',
    component: AllCoachesComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
