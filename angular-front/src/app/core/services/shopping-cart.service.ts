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

  getShoppingCart() {
    return new ShoppingCart(
      [
        new ShoppingCartPosition(
          new Product(
            1,
            'Bardzo małe rzeczy w stumilowym lesie',
            22.99,
            new Image('../../../assets/lalka.jpeg', 'ksiazka'),
            'miękka',
            'Catherine Hapka'
          ),
          3
        ),
        new ShoppingCartPosition(
          new Product(
            1,
            'Bardzo małe rzeczy w stumilowym lesie',
            22.99,
            new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
            'miękka',
            'Catherine Hapka'
          ),
          3
        ),
        new ShoppingCartPosition(
          new Product(
            1,
            'Bardzo małe rzeczy w stumilowym lesie',
            22.99,
            new Image('../../../assets/pan-tadeusz.jpeg', 'ksiazka'),
            'miękka',
            'Catherine Hapka'
          ),
          3
        ),
        new ShoppingCartPosition(
          new Product(
            1,
            'Bardzo małe rzeczy w stumilowym lesie',
            22.99,
            new Image('../../../assets/lalka.jpeg', 'ksiazka'),
            'miękka',
            'Catherine Hapka'
          ),
          3
        ),
      ],
      2020,
      222.99
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
            this.shoppingCartChanged.emit(this.getShoppingCart());
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
            this.shoppingCartChanged.emit(this.getShoppingCart());
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
