/* eslint-disable no-unused-vars */
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ProductDetails, ProductsService } from 'src/app/core';
import { Subscription, timer } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

enum PopupMessage {
  accept = 'Dodano produkt do koszyka',
  deny = 'Brak produktu na stanie magazynu',
}

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.scss'],
})
export class ProductPageComponent implements OnInit, OnDestroy {
  private productsService: ProductsService;
  product?: ProductDetails;
  showPopup: boolean = false;
  popupMessage: string = PopupMessage.accept;
  popupMode: 'accept' | 'deny' = 'accept';
  disabledButton: boolean = false;
  private showPopupSub?: Subscription;
  private route: ActivatedRoute;
  private routeSub?: Subscription;

  constructor(productsService: ProductsService, route: ActivatedRoute) {
    this.productsService = productsService;
    this.route = route;
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params) => {
      this.product = this.productsService.getProduct(+params['id']);
    });
  }

  onButtonClick() {
    this.showPopup = true;
    this.disabledButton = true;
    this.popupMessage = PopupMessage[this.popupMode];
    this.showPopupSub?.unsubscribe();
    this.showPopupSub = timer(3000).subscribe(() => {
      this.showPopup = false;
      this.disabledButton = false;
    });
  }

  ngOnDestroy(): void {
    this.showPopupSub?.unsubscribe();
    this.routeSub?.unsubscribe();
  }
}
