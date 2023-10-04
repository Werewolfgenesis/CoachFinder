import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllCoachesComponent } from './components/all-coaches/all-coaches.component';
import { RequestsComponent } from './components/requests/requests.component';
import { RegisterComponent } from './components/register/register.component';

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
  {
    path: 'requests',
    component: RequestsComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
