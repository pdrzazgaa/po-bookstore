import {
  Image,
  Order,
  OrderDetails,
  OrderPosition,
  Product,
  Reclamation,
  Status,
} from '../models';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';

@Injectable()
export class OrdersService {
  private http: HttpClient;
  private userService: UserService;
  private baseUrl = 'http://localhost:6060/';

  private orders: Order[] = [
    new Order(112345, Status.OrderPaid, 150.99, new Date('2022-05-20')),
    new Order(121234, Status.OrderPaid, 10.99, new Date('2022-05-20')),
    new Order(378653, Status.OrderPaid, 550.39, new Date('2022-05-20')),
    new Order(234234, Status.OrderPaid, 300, new Date('2022-05-20')),
  ];

  constructor(http: HttpClient, userService: UserService) {
    this.http = http;
    this.userService = userService;
  }

  getOrders(): Observable<Order[]> {
    return this.http
      .get<any[]>(this.baseUrl + `orders/${this.userService.getUserId()}`)
      .pipe(
        map((res) =>
          res.map(
            (order) =>
              new Order(
                order.orderNumber,
                Status[order.orderStatus],
                order.sum,
                new Date(order.date)
              )
          )
        )
      );
  }

  getOrderDetails(orderNumber: any): Observable<any> {
    return this.http
      .get(this.baseUrl + 'order/' + orderNumber + '/' + this.userService.getUserId())
      .pipe(
        map((res: any) => {
          const orderPositions: OrderPosition[] = res.cart.cartItems.map((item) => ({
            product: new Product(
              item.product.id,
              item.product.name,
              item.product.price,
              new Image('../../../assets/kubus-puchatek.jpeg', item.product.name),
              'twarda',
              item.product.author
            ),
            amount: item.quantity,
          }));
          return new OrderDetails(
            res.orderNumber,
            Status[res.orderStatus],
            res.sum,
            new Date(res.date),
            orderPositions
          );
        })
      );
  }

  sendReclamation(reclamation: Reclamation) {
    console.log(reclamation);
  }
}
