import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShoppingCartRoutingModule } from './shopping-cart-routing.module';
import { ShoppingCartPageComponent } from './shopping-cart-page/shopping-cart-page.component';
import { OrderingPageComponent } from './ordering-page/ordering-page.component';


@NgModule({
  declarations: [
    ShoppingCartPageComponent,
    OrderingPageComponent
  ],
  imports: [
    CommonModule,
    ShoppingCartRoutingModule
  ]
})
export class ShoppingCartModule { }
