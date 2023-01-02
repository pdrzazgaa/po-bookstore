import { CommonModule } from '@angular/common';
import { HistoryRoutingModule } from './history-routing.module';
import { NgModule } from '@angular/core';
import { OrderPageComponent } from './order-page';
import { OrdersPageComponent } from './orders-page';
import { ReclamationPageComponent } from './reclamation-page';

@NgModule({
  declarations: [OrdersPageComponent, OrderPageComponent, ReclamationPageComponent],
  imports: [CommonModule, HistoryRoutingModule],
  exports: [OrdersPageComponent, OrderPageComponent, ReclamationPageComponent],
})
export class HistoryModule {}
