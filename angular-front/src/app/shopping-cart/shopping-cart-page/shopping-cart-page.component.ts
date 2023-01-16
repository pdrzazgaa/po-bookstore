import { Component, OnInit } from '@angular/core';
import { ShoppingCart, ShoppingCartPosition, ShoppingCartService } from 'src/app/core';

@Component({
  selector: 'app-shopping-cart-page',
  templateUrl: './shopping-cart-page.component.html',
  styleUrls: ['./shopping-cart-page.component.scss'],
})
export class ShoppingCartPageComponent implements OnInit {
  private shoppingCartService: ShoppingCartService;
  shoppingCart?: ShoppingCart;

  constructor(shoppingCartService: ShoppingCartService) {
    this.shoppingCartService = shoppingCartService;
  }

  ngOnInit(): void {
    this.shoppingCart = this.shoppingCartService.getShoppingCart();
    this.shoppingCartService.shoppingCartChanged.subscribe(
      (shoppingCart) => (this.shoppingCart = shoppingCart)
    );
  }

  getProductSum(position: ShoppingCartPosition) {
    return position.amount * position.product.price;
  }
}
