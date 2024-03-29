/* eslint-disable no-unused-vars */
import { ActivatedRoute, Router } from '@angular/router';
import {
  AuthorizationService,
  ProductDetails,
  ProductsService,
  ShoppingCartService,
} from 'src/app/core';
import { Component, OnDestroy, OnInit } from '@angular/core';
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
  private productsService: ProductsService;
  private shoppingCartService: ShoppingCartService;
  private authorizationService: AuthorizationService;
  product?: ProductDetails;
  showPopup: boolean = false;
  popupMessage?: string;
  popupMode?: 'accept' | 'deny';
  disabledButton: boolean = false;
  private route: ActivatedRoute;
  private routeSub?: Subscription;
  private router: Router;
  private productSub?: Subscription;
  private buttonSub?: Subscription;
  private cartSub?: Subscription;
  buttonMessage?: 'Dodaj do koszyka' | 'Zaloguj się, aby dodać do koszyka';

  constructor(
    productsService: ProductsService,
    authorizationService: AuthorizationService,
    route: ActivatedRoute,
    shoppingCartService: ShoppingCartService,
    router: Router
  ) {
    this.productsService = productsService;
    this.route = route;
    this.shoppingCartService = shoppingCartService;
    this.authorizationService = authorizationService;
    this.router = router;
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params) => {
      this.productSub = this.productsService
        .getProduct(+params['id'])
        .subscribe((res) => {
          this.product = res;
        });
    });
    this.buttonMessage = this.authorizationService.isLoggedIn()
      ? 'Dodaj do koszyka'
      : 'Zaloguj się, aby dodać do koszyka';
  }

  onButtonClick() {
    if (this.authorizationService.isLoggedIn()) {
      this.disabledButton = true;
      this.cartSub = this.shoppingCartService
        .incrementProductAmount(this.product!.id)
        .subscribe((isAdded) => {
          if (isAdded) {
            this.popupMessage = PopupMessage.accept;
            this.popupMode = 'accept';
          } else {
            this.popupMessage = PopupMessage.deny;
            this.popupMode = 'deny';
          }
          this.showPopup = true;
          this.popupMessage = PopupMessage[this.popupMode];
          this.buttonSub?.unsubscribe();
          this.buttonSub = timer(2500).subscribe(() => {
            console.log('button subscribed');
            this.showPopup = false;
            this.disabledButton = false;
          });
        });
    } else {
      this.router.navigate(['/log-in']);
    }
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
    this.productSub?.unsubscribe();
    this.buttonSub?.unsubscribe();
    this.cartSub?.unsubscribe();
  }
}
