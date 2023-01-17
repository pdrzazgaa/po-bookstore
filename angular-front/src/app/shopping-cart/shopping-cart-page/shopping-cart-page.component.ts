import { Component, OnDestroy, OnInit } from '@angular/core';
import { ShoppingCart, ShoppingCartPosition, ShoppingCartService } from 'src/app/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-shopping-cart-page',
  templateUrl: './shopping-cart-page.component.html',
  styleUrls: ['./shopping-cart-page.component.scss'],
})
export class ShoppingCartPageComponent implements OnInit, OnDestroy {
  private shoppingCartService: ShoppingCartService;
  shoppingCart?: ShoppingCart;
  private shoppingCartSub?: Subscription;

  constructor(shoppingCartService: ShoppingCartService) {
    this.shoppingCartService = shoppingCartService;
  }

  ngOnInit(): void {
    this.shoppingCartSub = this.shoppingCartService
      .getShoppingCart()
      .subscribe((cart) => {
        console.log('in cart getting', cart);
        this.shoppingCart = cart;
      });
    this.shoppingCartService.shoppingCartChanged.subscribe(
      (shoppingCart) => (this.shoppingCart = shoppingCart)
    );
  }

  getProductSum(position: ShoppingCartPosition) {
    return position.amount * position.product.price;
  }

  ngOnDestroy(): void {
    this.shoppingCartSub?.unsubscribe();
  }
}
