import { Image, Product } from '../models';
import { Injectable } from '@angular/core';

@Injectable()
export class ProductsService {
  private products: Product[] = [
    new Product(
      1,
      'Bardzo małe rzeczy w stumilowym lesie',
      22.99,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'Catherine Hapka'
    ),
    new Product(
      2,
      'Nad niemnem',
      22.99,
      new Image('../../../assets/nad-niemnem.jpg', 'ksiazka'),
      'Eliza Orzeszkowa'
    ),
    new Product(
      3,
      'Lalka',
      122.99,
      new Image('../../../assets/lalka.jpeg', 'ksiazka'),
      'Bolesław Prus'
    ),
    new Product(
      4,
      'Bardzo małe rzeczy',
      24.99,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'Catherine Hapka'
    ),
    new Product(
      5,
      'Pan Tadeusz',
      62.99,
      new Image('../../../assets/pan-tadeusz.jpeg', 'ksiazka'),
      'Adam Mickiewiz'
    ),
    new Product(
      6,
      'Nad niemnem',
      22.99,
      new Image('../../../assets/nad-niemnem.jpg', 'ksiazka'),
      'Eliza Orzeszkowa'
    ),
    new Product(
      7,
      'Bardzo małe rzeczy',
      12.89,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'Catherine Hapka'
    ),
    new Product(
      8,
      'Bardzo małe rzeczy',
      22.99,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'Adrian Kowalski'
    ),
    new Product(
      9,
      'Bardzo małe rzeczy',
      113.99,
      new Image('../../../assets/pan-tadeusz.jpeg', 'ksiazka'),
      'Adam Mickiewicz'
    ),
    new Product(
      10,
      'Bardzo małe rzeczy',
      22.99,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'Catherine Hapka'
    ),
  ];

  getProducts(category?: string, subcategory?: string) {
    console.log(category, subcategory);
    return [...this.products];
  }
}
