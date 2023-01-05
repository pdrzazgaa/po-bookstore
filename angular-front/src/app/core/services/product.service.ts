import { Image, ProductDetails } from '../models';
import { Injectable } from '@angular/core';
@Injectable()
export class ProductService {
  private product: ProductDetails = new ProductDetails(
    1,
    'Bardzo małe rzeczy',
    22.99,
    new Image('../../../assets/kubus-puchatek.jpeg', 'ksiazka'),
    'Refleksje o zyciu i przyjaźni podniosą na duchu czytelników w kazdym wieku dzięki prostym i pięknie ilustrowanym afirmacjom. Chwile spędzone na wędrówce po Stumilowym Lesie w towarzystwie Kubusia Puchatka przypominają, ze nawet najmniejsze rzeczy są źródłem szczęścia i wdzięczności.',
    'Catherine Hapka',
    'Olesiejuk',
    new Date('2022-05-20'),
    128,
    'miękka',
    'Bardzo małe rzeczy. Proste refleksje o zyciu i przyjaźni ze Stumilowego Lasu'
  );

  getProduct() {
    return this.product;
  }
}
