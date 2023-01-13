import {
  Address,
  Delivery,
  Image,
  Payment,
  Product,
  ShoppingCart,
  ShoppingCartPosition,
} from '../models';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';

@Injectable()
export class ShoppingCartService {
  //   private shoppingCart?: ShoppingCart;
  private userService: UserService;

  constructor(userService: UserService) {
    this.userService = userService;
  }

  getShoppingCart() {
    return new ShoppingCart(
      [
        new ShoppingCartPosition(
          new Product(
            1,
            'Bardzo małe rzeczy w stumilowym lesie',
            22.99,
            new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
            'Catherine Hapka'
          ),
          3
        ),
      ],
      2020,
      222.99
    );
  }

  incrementProductAmount(productId: number) {
    console.log(this.userService.getUserId(), productId);
    return 1;
  }

  decrementProductAmount(productId: number) {
    console.log(this.userService.getUserId(), productId);
    return 1;
  }

  makeNewOrder(
    forname: string,
    surname: string,
    mail: string,
    phoneNumber: number,
    address: Address,
    delivery: Delivery,
    payment: Payment,
    bookcoins: number,
    cartId: number
  ) {
    console.log(
      forname,
      surname,
      mail,
      phoneNumber,
      address,
      delivery,
      payment,
      bookcoins,
      cartId
    );
  }
}
