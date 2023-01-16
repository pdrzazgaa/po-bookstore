import { Image } from './image.model';

export type Cover = 'twarda' | 'miękka';

export class Product {
  public id: number;
  public name: string;
  public price: number;
  public image: Image;
  public cover: Cover;
  public author?: string;

  constructor(
    id: number,
    name: string,
    price: number,
    image: Image,
    cover: Cover,
    author?: string
  ) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.image = image;
    this.cover = cover;
    this.author = author;
  }
}
