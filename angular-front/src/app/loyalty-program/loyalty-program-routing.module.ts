import { RouterModule, Routes } from '@angular/router';
import { AuthorizationGuardService } from '../core';
import { LoyaltyProgramPageComponent } from './loyalty-program-page';
import { NgModule } from '@angular/core';

const routes: Routes = [
  {
    path: 'loyalty-program',
    component: LoyaltyProgramPageComponent,
    canActivate: [AuthorizationGuardService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LoyaltyProgramRoutingModule {}
