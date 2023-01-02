import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { OrderingPageComponent } from './ordering-page';
import { ShoppingCartPageComponent } from './shopping-cart-page';
import { ShoppingCartRoutingModule } from './shopping-cart-routing.module';

@NgModule({
  declarations: [ShoppingCartPageComponent, OrderingPageComponent],
  imports: [CommonModule, ShoppingCartRoutingModule],
  exports: [ShoppingCartPageComponent, OrderingPageComponent],
})
export class ShoppingCartModule {}
