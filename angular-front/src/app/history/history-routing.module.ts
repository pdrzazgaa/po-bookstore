import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { OrderPageComponent } from './order-page';
import { OrdersPageComponent } from './orders-page';
import { ReclamationPageComponent } from './reclamation-page';

const routes: Routes = [
  { path: 'order', component: OrderPageComponent },
  { path: 'orders', component: OrdersPageComponent },
  { path: 'reclamation', component: ReclamationPageComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HistoryRoutingModule {}
