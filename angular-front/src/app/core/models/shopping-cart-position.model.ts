import { Product } from './product.model';

export class ShoppingCartPosition {
  public product: Product;
  public amount: number;

  constructor(product: Product, amount: number) {
    this.product = product;
    this.amount = amount;
  }
}
