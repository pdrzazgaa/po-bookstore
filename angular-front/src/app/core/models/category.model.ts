export class Category {
  public category: string;
  public subcategories: string[];

  constructor(category: string, subcategories: string[]) {
    this.category = category;
    this.subcategories = [...subcategories];
  }
}
