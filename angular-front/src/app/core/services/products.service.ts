import { Image, Product } from '../models';
import { Injectable } from '@angular/core';

@Injectable()
export class ProductsService {
  private products: Product[] = [
    new Product(
      1,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      2,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      3,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      4,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      5,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      6,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      7,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      8,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      9,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      10,
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
  ];

  getProducts(category?: string, subcategory?: string) {
    console.log(category, subcategory);
    return [...this.products];
  }
}
