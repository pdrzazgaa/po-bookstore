/* eslint-disable no-unused-vars */
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ProductDetails, ProductService } from 'src/app/core';
import { Subscription, timer } from 'rxjs';

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
  private productService: ProductService;
  product!: ProductDetails;
  showPopup: boolean = false;
  popupMessage: string = PopupMessage.accept;
  popupMode: 'accept' | 'deny' = 'accept';
  disabledButton: boolean = false;
  private showPopupSub?: Subscription;

  constructor(productService: ProductService) {
    this.productService = productService;
  }

  ngOnInit(): void {
    this.product = this.productService.getProduct();
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
  }
}
