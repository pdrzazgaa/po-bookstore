import { CommonModule } from '@angular/common';
import { HistoryRoutingModule } from './history-routing.module';
import { NgModule } from '@angular/core';
import { OrderPageComponent } from './order-page';
import { OrdersPageComponent } from './orders-page';
import { ReclamationPageComponent } from './reclamation-page';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [OrdersPageComponent, OrderPageComponent, ReclamationPageComponent],
  imports: [CommonModule, HistoryRoutingModule, SharedModule],
  exports: [OrdersPageComponent, OrderPageComponent, ReclamationPageComponent],
})
export class HistoryModule {}
