import { Order, Status } from './order.model';
import { Product } from './product.model';

interface OrderPosition {
  product: Product;
  amount: number;
}

export class OrderDetails extends Order {
  public orderPositions: OrderPosition[];

  constructor(
    id: number,
    status: Status,
    totalPrice: number,
    date: Date,
    orderPositions: OrderPosition[]
  ) {
    super(id, status, totalPrice, date);
    this.orderPositions = orderPositions;
  }
}
