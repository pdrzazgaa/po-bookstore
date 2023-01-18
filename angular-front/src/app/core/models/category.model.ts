export class Category {
  public name: string;
  public id: number;
  public subcategories: Category[];

  constructor(id: number, name: string, subcategories: Category[]) {
    this.id = id;
    this.name = name;
    this.subcategories = [...subcategories];
  }
}
