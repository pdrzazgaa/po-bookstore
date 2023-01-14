import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { OrderingPageComponent } from './ordering-page';
import { SharedModule } from '../shared/shared.module';
import { ShoppingCartPageComponent } from './shopping-cart-page';
import { ShoppingCartRoutingModule } from './shopping-cart-routing.module';

@NgModule({
  declarations: [ShoppingCartPageComponent, OrderingPageComponent],
  imports: [
    CommonModule,
    ShoppingCartRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [ShoppingCartPageComponent, OrderingPageComponent],
})
export class ShoppingCartModule {}
