import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HistoryRoutingModule } from './history-routing.module';
import { OrdersPageComponent } from './orders-page/orders-page.component';
import { OrderPageComponent } from './order-page/order-page.component';
import { ReclamationPageComponent } from './reclamation-page/reclamation-page.component';


@NgModule({
  declarations: [
    OrdersPageComponent,
    OrderPageComponent,
    ReclamationPageComponent
  ],
  imports: [
    CommonModule,
    HistoryRoutingModule
  ]
})
export class HistoryModule { }
