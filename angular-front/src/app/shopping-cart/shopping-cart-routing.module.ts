import { RouterModule, Routes } from '@angular/router';
import { AuthorizationService } from '../core';
import { NgModule } from '@angular/core';
import { OrderingPageComponent } from './ordering-page';
import { ShoppingCartPageComponent } from './shopping-cart-page';

const routes: Routes = [
  {
    path: 'shopping-cart',
    component: ShoppingCartPageComponent,
    canActivate: [AuthorizationService],
  },
  {
    path: 'ordering',
    component: OrderingPageComponent,
    canActivate: [AuthorizationService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ShoppingCartRoutingModule {}
