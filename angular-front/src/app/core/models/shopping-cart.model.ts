import { ShoppingCartPosition } from './shopping-cart-position.model';

export class ShoppingCart {
  public positions: ShoppingCartPosition[];

  constructor(positions: ShoppingCartPosition[]) {
    this.positions = positions;
  }
}
