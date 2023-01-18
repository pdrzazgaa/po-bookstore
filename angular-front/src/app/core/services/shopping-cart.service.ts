import {
  Address,
  Delivery,
  Image,
  Payment,
  Product,
  ShoppingCart,
  ShoppingCartPosition,
} from '../models';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserService } from './user.service';

@Injectable()
export class ShoppingCartService {
  private userService: UserService;
  private http: HttpClient;
  private baseUrl = 'http://localhost:6060/';
  private headers = { 'content-type': 'application/json' };
  shoppingCartChanged = new EventEmitter<ShoppingCart | null>();

  constructor(userService: UserService, http: HttpClient) {
    this.userService = userService;
    this.http = http;
  }

  getShoppingCart(): Observable<ShoppingCart | null> {
    return this.http.get(this.baseUrl + 'cart/' + this.userService.getUserId()).pipe(
      catchError(() => {
        return of(null);
      }),
      map((res: any) => {
        if (res) {
          const shoppingCartPositions: ShoppingCartPosition[] = res.cartItems.map(
            (item) =>
              new ShoppingCartPosition(
                new Product(
                  item.product.id,
                  item.product.name,
                  item.product.price,
                  new Image(`../../../assets/${item.product.id}.jpg`, item.product.name),
                  item.product.coverType === 'HardCover' ? 'twarda' : 'miękka',
                  item.product.author
                ),
                item.quantity
              )
          );
          return new ShoppingCart(shoppingCartPositions, res.id, res.cartSum);
        } else return null;
      })
    );
  }

  incrementProductAmount(productId: number): Observable<boolean> {
    return this.http
      .post(
        this.baseUrl + 'addCartItem',
        JSON.stringify({ clientID: this.userService.getUserId(), productID: productId }),
        { headers: this.headers }
      )
      .pipe(
        map((res) => {
          if (res === 'OK') {
            this.getShoppingCart().subscribe((cart) => {
              this.shoppingCartChanged.emit(cart);
            });
            return true;
          } else {
            return false;
          }
        })
      );
  }

  decrementProductAmount(productId: number): Observable<boolean> {
    return this.http
      .post(
        this.baseUrl + 'removeCartItem',
        JSON.stringify({ clientID: this.userService.getUserId(), productID: productId }),
        { headers: this.headers }
      )
      .pipe(
        map((res) => {
          if (res === 'OK') {
            this.getShoppingCart().subscribe((cart) => {
              this.shoppingCartChanged.emit(cart);
            });
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
  ): Observable<number> {
    const headers = { 'content-type': 'application/json' };
    const obj = JSON.stringify({
      forname: forname,
      surname: surname,
      nip: NIP,
      companyName: companyName,
      mail: mail,
      phoneNumber: phoneNumber,
      address: address,
      delivery: delivery,
      payment: payment,
      bookcoins: bookcoins,
      cartId: cartId,
      document: document,
    });
    return this.http.post(this.baseUrl + 'createOrder', obj, { headers: headers }).pipe(
      map((res: any) => {
        if (res === 'OK') {
          return 1;
        } else {
          return -1;
        }
      })
    );
  }
}
