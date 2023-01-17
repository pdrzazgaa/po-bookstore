import { Order, Status } from './order.model';
import { Product } from './product.model';

export type OrderPosition = {
  product: Product;
  amount: number;
};

export class OrderDetails extends Order {
  public orderPositions: OrderPosition[];
  public canComplain: boolean;

  constructor(
    orderNum: number,
    status: Status,
    totalPrice: number,
    date: Date,
    orderPositions: OrderPosition[],
    canComplain: boolean
  ) {
    super(orderNum, status, totalPrice, date);
    this.orderPositions = orderPositions;
    this.canComplain = canComplain;
  }
}
