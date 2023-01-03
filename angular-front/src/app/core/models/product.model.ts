import { Category } from './category.model';

export class Product {
  public name: string;
  public price: number;
  public description: string;
  public categories: Category[];

  constructor(name: string, price: number, description: string, categories: Category[]) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.categories = categories;
  }
}
