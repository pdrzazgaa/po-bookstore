import { RouterModule, Routes } from '@angular/router';
import { AuthorizationGuardService } from '../core';
import { NgModule } from '@angular/core';
import { OrderPageComponent } from './order-page';
import { OrdersPageComponent } from './orders-page';
import { ReclamationPageComponent } from './reclamation-page';

const routes: Routes = [
  {
    path: 'order/:id',
    component: OrderPageComponent,
    canActivate: [AuthorizationGuardService],
  },
  {
    path: 'orders',
    component: OrdersPageComponent,
    // canActivate: [AuthorizationGuardService],
  },
  {
    path: 'reclamation/:orderId',
    component: ReclamationPageComponent,
    canActivate: [AuthorizationGuardService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HistoryRoutingModule {}
