import { ShoppingCartPosition } from './shopping-cart-position.model';

export class ShoppingCart {
  public positions: ShoppingCartPosition[];
  public cartId: number;
  public totalAmount: number;

  constructor(positions: ShoppingCartPosition[], cartId: number, totalAmount: number) {
    this.positions = positions;
    this.cartId = cartId;
    this.totalAmount = totalAmount;
  }
}
