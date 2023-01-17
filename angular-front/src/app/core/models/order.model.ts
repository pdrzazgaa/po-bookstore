/* eslint-disable no-unused-vars */

export enum Status {
  OrderCancelled = 'Wycofane',
  OrderPaymentDue = 'Do zapłaty',
  OrderPaid = 'Opłacone',
  OrderProcessing = 'W realizacji',
  OrderReadyForSend = 'Gotowe do wysyłki',
  OrderInTransit = 'W drodze do dostarczenia',
  OrderDelivered = 'Dostarczone',
  OrderReturned = 'Zwrócone',
}

export class Order {
  public orderNum: number;
  public status: Status;
  public totalPrice: number;
  public date: Date;

  constructor(orderNum: number, status: Status, totalPrice: number, date: Date) {
    this.orderNum = orderNum;
    this.status = status;
    this.totalPrice = totalPrice;
    this.date = date;
  }
}
