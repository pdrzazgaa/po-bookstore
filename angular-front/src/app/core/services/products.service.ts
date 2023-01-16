import { Image, Product, ProductDetails } from '../models';
import { Injectable } from '@angular/core';

@Injectable()
export class ProductsService {
  private products: Product[] = [
    new Product(
      1,
      'Bardzo małe rzeczy w stumilowym lesie',
      22.99,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'miękka',
      'Catherine Hapka'
    ),
    new Product(
      2,
      'Nad niemnem',
      22.99,
      new Image('../../../assets/nad-niemnem.jpg', 'ksiazka'),
      'miękka',
      'Eliza Orzeszkowa'
    ),
    new Product(
      3,
      'Lalka',
      122.99,
      new Image('../../../assets/lalka.jpeg', 'ksiazka'),
      'miękka',
      'Bolesław Prus'
    ),
    new Product(
      4,
      'Bardzo małe rzeczy',
      24.99,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'miękka',
      'Catherine Hapka'
    ),
    new Product(
      5,
      'Pan Tadeusz',
      62.99,
      new Image('../../../assets/pan-tadeusz.jpeg', 'ksiazka'),
      'miękka',
      'Adam Mickiewiz'
    ),
    new Product(
      6,
      'Nad niemnem',
      22.99,
      new Image('../../../assets/nad-niemnem.jpg', 'ksiazka'),
      'miękka',
      'Eliza Orzeszkowa'
    ),
    new Product(
      7,
      'Bardzo małe rzeczy',
      12.89,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'miękka',
      'Catherine Hapka'
    ),
    new Product(
      8,
      'Bardzo małe rzeczy',
      22.99,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'miękka',
      'Adrian Kowalski'
    ),
    new Product(
      9,
      'Bardzo małe rzeczy',
      113.99,
      new Image('../../../assets/pan-tadeusz.jpeg', 'ksiazka'),
      'twarda',
      'Adam Mickiewicz'
    ),
    new Product(
      10,
      'Bardzo małe rzeczy',
      22.99,
      new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
      'twarda',
      'Catherine Hapka'
    ),
  ];

  private product: ProductDetails = new ProductDetails(
    1,
    'Bardzo małe rzeczy',
    22.99,
    new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
    'Refleksje o zyciu i przyjaźni podniosą na duchu czytelników w kazdym wieku dzięki prostym i pięknie ilustrowanym afirmacjom. Chwile spędzone na wędrówce po Stumilowym Lesie w towarzystwie Kubusia Puchatka przypominają, ze nawet najmniejsze rzeczy są źródłem szczęścia i wdzięczności.',
    'miękka',
    'Catherine Hapka',
    'Olesiejuk',
    new Date('2022-05-20'),
    128,
    'Bardzo małe rzeczy. Proste refleksje o zyciu i przyjaźni ze Stumilowego Lasu'
  );

  getProduct(productId: number) {
    const product = this.products.find(({ id }) => id === +productId);

    return (
      product &&
      new ProductDetails(
        product?.id,
        product?.name,
        product?.price,
        product?.image,
        'Refleksje o zyciu i przyjaźni podniosą na duchu czytelników w kazdym wieku dzięki prostym i pięknie ilustrowanym afirmacjom. Chwile spędzone na wędrówce po Stumilowym Lesie w towarzystwie Kubusia Puchatka przypominają, ze nawet najmniejsze rzeczy są źródłem szczęścia i wdzięczności.',
        'miękka',
        product?.author,
        'Olesiejuk',
        new Date('2022-05-20'),
        128,
        product?.name
      )
    );
  }

  getProducts(category?: string, subcategory?: string) {
    console.log(category, subcategory);
    return [...this.products];
  }
}
