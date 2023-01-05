import { Component, OnDestroy, OnInit } from '@angular/core';
import { Product, ProductsService } from 'src/app/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-products-page',
  templateUrl: './products-page.component.html',
  styleUrls: ['./products-page.component.scss'],
})
export class ProductsPageComponent implements OnInit, OnDestroy {
  private productsService: ProductsService;
  public products: Product[] = [];
  private route: ActivatedRoute;
  private routeSub?: Subscription;

  constructor(productsService: ProductsService, route: ActivatedRoute) {
    this.productsService = productsService;
    this.route = route;
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params) => {
      this.products = this.productsService.getProducts(
        params['category'],
        params['subcategory']
      );
    });
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }
}
