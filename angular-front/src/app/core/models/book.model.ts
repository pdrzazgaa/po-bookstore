import { Category } from './category.model';
import { Product } from './product.model';

export type Cover = 'miękka' | 'twarda';

export class Book extends Product {
  public title: string;
  public author: string;
  public publisher: string;
  public dateOfPublication: Date;
  public nrOfPages: number;
  public language: string;
  public cover: Cover;

  constructor(
    name: string,
    price: number,
    description: string,
    categories: Category[],
    title: string,
    author: string,
    publisher: string,
    dateOfPublication: Date,
    nrOfPages: number,
    language: string,
    cover: Cover
  ) {
    super(name, price, description, categories);
    this.author = author;
    this.title = title;
    this.publisher = publisher;
    this.dateOfPublication = dateOfPublication;
    this.nrOfPages = nrOfPages;
    this.language = language;
    this.cover = cover;
  }
}
