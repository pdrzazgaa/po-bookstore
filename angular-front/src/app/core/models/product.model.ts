import { Image } from './image.model';

export class Product {
  public name: string;
  public price: number;
  public image: Image;
  public author?: string;

  constructor(name: string, price: number, image: Image, author?: string) {
    this.name = name;
    this.price = price;
    this.image = image;
    this.author = author;
  }
}
