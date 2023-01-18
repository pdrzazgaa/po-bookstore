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
  errorMessage: string = '';
  showErrorPopup: boolean = false;

  constructor(shoppingCartService: ShoppingCartService) {
    this.shoppingCartService = shoppingCartService;
  }

  ngOnInit(): void {
    this.shoppingCartSub = this.shoppingCartService
      .getShoppingCart()
      .subscribe((cart) => {
        if (cart) {
          this.shoppingCart = cart;
        }
      });
    this.shoppingCartService.shoppingCartChanged.subscribe((shoppingCart) => {
      this.shoppingCart = shoppingCart;
    });
  }

  getProductSum(position: ShoppingCartPosition) {
    return position.amount * position.product.price;
  }

  incrementAmount(productId: number) {
    this.shoppingCartService.incrementProductAmount(productId).subscribe((res) => {
      if (!res) {
        this.errorMessage = 'Brak większej liczby produktów na stanie';
        this.showErrorPopup = true;
      }
    });
  }

  decrementAmount(productId: number) {
    this.shoppingCartService.decrementProductAmount(productId).subscribe((res) => {
      console.log(res, ' from decrement');
    });
  }

  onErrorMessagePopupClose(isClosed: boolean) {
    if (isClosed) {
      this.showErrorPopup = false;
    }
  }

  ngOnDestroy(): void {
    this.shoppingCartSub?.unsubscribe();
  }
}
