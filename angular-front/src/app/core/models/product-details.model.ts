import { Cover, Product } from './product.model';
import { Image } from './image.model';

export class ProductDetails extends Product {
  public description: string;
  public publisher?: string;
  public productionDate?: Date;
  public pagesNr?: number;
  public title?: string;

  constructor(
    id: number,
    name: string,
    price: number,
    image: Image,
    description: string,
    cover: Cover,
    author?: string,
    publisher?: string,
    productionDate?: Date,
    pagesNr?: number,
    title?: string
  ) {
    super(id, name, price, image, cover, author);
    this.description = description;
    this.publisher = publisher;
    this.productionDate = productionDate;
    this.pagesNr = pagesNr;
    this.title = title;
  }
}
