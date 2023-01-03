import { Image } from './image.model';
import { Product } from './product.model';

export type Cover = 'twarda' | 'miękka';

export class ProductDetails extends Product {
  public description: string;
  public publisher?: string;
  public productionDate?: Date;
  public pagesNr?: number;
  public cover?: Cover;
  public title?: string;

  constructor(
    name: string,
    price: number,
    image: Image,
    description: string,
    author?: string,
    publisher?: string,
    productionDate?: Date,
    pagesNr?: number,
    cover?: Cover,
    title?: string
  ) {
    super(name, price, image, author);
    this.description = description;
    this.publisher = publisher;
    this.productionDate = productionDate;
    this.pagesNr = pagesNr;
    this.cover = cover;
    this.title = title;
  }
}
