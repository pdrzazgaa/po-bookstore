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
  private products: Product[] = [];
  public productsToShow: Product[] = [];
  private route: ActivatedRoute;
  private routeSub?: Subscription;
  private productsSub?: Subscription;

  constructor(productsService: ProductsService, route: ActivatedRoute) {
    this.productsService = productsService;
    this.route = route;
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params) => {
      this.productsSub = this.productsService
        .getProducts(params['idCat'])
        .subscribe((products) => {
          this.products = products;
          this.productsToShow = products;
          console.log(this.products);
        });
      this.productsToShow = this.products;
    });
  }

  onFiltersChanged(filter: { price: string; cover: string }) {
    let filterProducts = this.products;
    if (filter.price && filter.price != 'show-all') {
      filterProducts = filterProducts.filter((product) => product.price < +filter.price);
    }
    if (filter.cover && filter.cover != 'show-all') {
      filterProducts = filterProducts.filter((product) => product.cover === filter.cover);
    }
    console.log(filter.price, filter.cover);
    this.productsToShow = filterProducts;
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
    this.productsSub?.unsubscribe();
  }
}
