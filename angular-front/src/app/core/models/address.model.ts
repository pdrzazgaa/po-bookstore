export class Address {
  street: string;
  num: string;
  city: string;
  postcode: string;
  country: string;

  constructor(
    street: string,
    num: string,
    city: string,
    postcode: string,
    country: string
  ) {
    this.street = street;
    this.num = num;
    this.city = city;
    this.postcode = postcode;
    this.country = country;
  }
}
