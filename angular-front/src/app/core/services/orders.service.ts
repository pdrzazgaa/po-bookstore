import { Image, Order, OrderDetails, Product, Reclamation, Status } from '../models';
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

  fetchOrderDetails(orderNumber: any): Observable<any> {
    return this.http
      .get(this.baseUrl + 'order/' + orderNumber + '/' + this.userService.getUserId())
      .pipe(map((res) => console.log(res)));
  }

  getOrderDetails(orderNumber: string) {
    this.fetchOrderDetails(orderNumber).subscribe();
    const order = this.orders.find(({ id }) => id === 112345);

    return (
      order &&
      new OrderDetails(order.id, order.status, order.totalPrice, order.date, [
        {
          product: new Product(
            1,
            'Bardzo małe rzeczy w stumilowym lesie',
            22.99,
            new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
            'miękka',
            'Catherine Hapka'
          ),
          amount: 2,
        },
        {
          product: new Product(
            2,
            'Nad niemnem',
            22.99,
            new Image('../../../assets/nad-niemnem.jpg', 'ksiazka'),
            'miękka',
            'Eliza Orzeszkowa'
          ),
          amount: 4,
        },
        {
          product: new Product(
            3,
            'Lalka',
            122.99,
            new Image('../../../assets/lalka.jpeg', 'ksiazka'),
            'miękka',
            'Bolesław Prus'
          ),
          amount: 1,
        },
      ])
    );
  }

  sendReclamation(reclamation: Reclamation) {
    console.log(reclamation);
  }
}
