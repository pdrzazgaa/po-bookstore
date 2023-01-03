import { Address } from './address.model';
import { Order } from './order.model';

export class User {
  public orders: Order[];
  public bookcoins: number;
  public forname: string;
  public surname: string;
  public address: Address;

  constructor(
    orders: Order[],
    bookcoins: number,
    forname: string,
    surname: string,
    address: Address
  ) {
    this.orders = orders;
    this.bookcoins = bookcoins;
    this.forname = forname;
    this.surname = surname;
    this.address = address;
  }
}
