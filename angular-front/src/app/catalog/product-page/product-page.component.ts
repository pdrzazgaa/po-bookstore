import { Component, OnInit } from '@angular/core';
import { ProductDetails, ProductService } from 'src/app/core';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.scss'],
})
export class ProductPageComponent implements OnInit {
  private productService: ProductService;
  product!: ProductDetails;

  constructor(productService: ProductService) {
    this.productService = productService;
  }

  ngOnInit(): void {
    this.product = this.productService.getProduct();
  }
}
