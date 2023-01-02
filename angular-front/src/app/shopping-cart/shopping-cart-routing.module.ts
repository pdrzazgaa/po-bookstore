import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { OrderingPageComponent } from './ordering-page';
import { ShoppingCartPageComponent } from './shopping-cart-page';

const routes: Routes = [
  { path: 'shopping-cart', component: ShoppingCartPageComponent },
  { path: 'ordering-page', component: OrderingPageComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ShoppingCartRoutingModule {}
