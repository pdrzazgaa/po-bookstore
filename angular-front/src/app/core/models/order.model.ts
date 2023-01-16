export type Status = 'W realizacji' | 'Wysłane' | 'Dostarczone';

export class Order {
  public id: number;
  public status: Status;
  public totalPrice: number;
  public date: Date;

  constructor(id: number, status: Status, totalPrice: number, date: Date) {
    this.id = id;
    this.status = status;
    this.totalPrice = totalPrice;
    this.date = date;
  }
}
