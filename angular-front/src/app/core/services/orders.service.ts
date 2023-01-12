import { Image, Order, OrderDetails, Product, Reclamation } from '../models';
import { Injectable } from '@angular/core';

@Injectable()
export class OrdersService {
  private orders: Order[] = [
    new Order(112345, 'Dostarczone', 150.99, new Date('2022-05-20')),
    new Order(121234, 'W realizacji', 10.99, new Date('2022-05-20')),
    new Order(378653, 'W realizacji', 550.39, new Date('2022-05-20')),
    new Order(234234, 'Wysłane', 300, new Date('2022-05-20')),
  ];

  getOrders(userId: number) {
    console.log(userId);
    return this.orders;
  }

  getOrderDetails(orderId: number) {
    const order = this.orders.find(({ id }) => id === orderId);

    return (
      order &&
      new OrderDetails(order.id, order.status, order.totalPrice, order.date, [
        {
          product: new Product(
            1,
            'Bardzo małe rzeczy w stumilowym lesie',
            22.99,
            new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
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
