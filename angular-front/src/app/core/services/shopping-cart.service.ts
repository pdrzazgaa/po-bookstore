import {
  Address,
  Delivery,
  Payment,
  ShoppingCart,
  ShoppingCartPosition,
} from '../models';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserService } from './user.service';

@Injectable()
export class ShoppingCartService {
  private userService: UserService;
  private http: HttpClient;
  private baseUrl = 'http://localhost:6060/';
  private headers = { 'content-type': 'application/json' };
  shoppingCartChanged = new EventEmitter<ShoppingCart>();

  constructor(userService: UserService, http: HttpClient) {
    this.userService = userService;
    this.http = http;
  }

  getShoppingCart(): Observable<ShoppingCart> {
    return this.http.get(this.baseUrl + 'cart/' + this.userService.getUserId()).pipe(
      map((res: any) => {
        const shoppingCartPositions: ShoppingCartPosition[] = [];
        return new ShoppingCart(shoppingCartPositions, res.id, res.cartSum);
      })
    );
  }

  incrementProductAmount(productId: number): Observable<boolean> {
    console.log(this.userService.getUserId(), productId, ' id before post, product id');
    return this.http
      .post(
        this.baseUrl + 'addCartItem',
        JSON.stringify({ clientID: this.userService.getUserId(), productID: productId }),
        { headers: this.headers }
      )
      .pipe(
        map((res) => {
          console.log('odbior', res);
          if (res === 'OK') {
            this.getShoppingCart()
              .subscribe((cart) => this.shoppingCartChanged.emit(cart))
              .unsubscribe();

            return true;
          } else {
            return false;
          }
        })
      );
  }

  decrementProductAmount(productId: number) {
    console.log(this.userService.getUserId(), productId);
    return this.http
      .post(
        this.baseUrl + 'removeCartItem',
        JSON.stringify({ clientID: this.userService.getUserId(), productID: productId }),
        { headers: this.headers }
      )
      .pipe(
        map((res) => {
          console.log('odbior', res);
          if (res === 'OK') {
            this.getShoppingCart()
              .subscribe((cart) => this.shoppingCartChanged.emit(cart))
              .unsubscribe();
            return true;
          } else {
            return false;
          }
        })
      );
  }

  makeNewOrder(
    mail: string,
    phoneNumber: string,
    address: Address,
    delivery: Delivery,
    payment: Payment,
    bookcoins: number,
    cartId: number,
    document: string,
    forname?: string,
    surname?: string,
    NIP?: string,
    companyName?: string
  ) {
    console.log(
      forname,
      surname,
      NIP,
      companyName,
      mail,
      phoneNumber,
      address,
      delivery,
      payment,
      bookcoins,
      cartId,
      document
    );
    return 1;
  }
}
