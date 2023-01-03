import { Injectable } from '@angular/core';
import { Product } from '../models';

@Injectable()
export class ProductsService {
  private products: Product[] = [];

  getProducts() {
    return [...this.products];
  }
}
