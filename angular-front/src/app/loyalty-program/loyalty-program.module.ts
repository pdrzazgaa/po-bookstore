import { CommonModule } from '@angular/common';
import { LoyaltyProgramPageComponent } from './loyalty-program-page';
import { LoyaltyProgramRoutingModule } from './loyalty-program-routing.module';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [LoyaltyProgramPageComponent],
  imports: [CommonModule, LoyaltyProgramRoutingModule, SharedModule],
})
export class LoyaltyProgramModule {}
