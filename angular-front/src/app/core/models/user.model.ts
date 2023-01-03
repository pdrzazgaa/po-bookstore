import { Address } from './address.model';
import { Order } from './order.model';

export class User {
  public orders: Order[];
  public inLoyaltyProgram: boolean;
  public forname: string;
  public surname: string;
  public bookcoins?: number;
  public address?: Address;

  constructor(
    orders: Order[],
    inLoyaltyProgram: boolean,
    forname: string,
    surname: string,
    bookcoins?: number,
    address?: Address
  ) {
    this.orders = orders;
    this.inLoyaltyProgram = inLoyaltyProgram;
    this.forname = forname;
    this.surname = surname;
    this.bookcoins = bookcoins;
    this.address = address;
  }
}
