import { Image } from './image.model';

export class Product {
  public id: number;
  public name: string;
  public price: number;
  public image: Image;
  public author?: string;

  constructor(id: number, name: string, price: number, image: Image, author?: string) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.image = image;
    this.author = author;
  }
}
