import { Injectable } from '@angular/core';
import { Product } from '../models';

@Injectable()
export class ProductService {
  private product?: Product;

  getProduct() {
    return this.product;
  }
}
