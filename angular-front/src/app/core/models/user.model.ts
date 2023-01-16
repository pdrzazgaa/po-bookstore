import { Address } from './address.model';

export class User {
  public id: number;
  public forname?: string;
  public surname?: string;
  public companyName?: string;
  public companyNIP?: string;
  public email: string;
  public phoneNumber: string;
  public address?: Address;

  constructor(
    id: number,
    forname: string,
    surname: string,
    email: string,
    phoneNumber: string,
    address?: Address
  ) {
    this.id = id;
    this.forname = forname;
    this.surname = surname;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }
}
