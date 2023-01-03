import { RouterModule, Routes } from '@angular/router';
import { LoyaltyProgramPageComponent } from './loyalty-program-page';
import { NgModule } from '@angular/core';

const routes: Routes = [
  { path: 'loyalty-program', component: LoyaltyProgramPageComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LoyaltyProgramRoutingModule {}
