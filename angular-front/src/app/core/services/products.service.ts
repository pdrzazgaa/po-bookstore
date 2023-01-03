import { Image, Product } from '../models';
import { Injectable } from '@angular/core';

@Injectable()
export class ProductsService {
  private products: Product[] = [
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
    new Product(
      'Bardzo małe rzeczy',
      22.99,
      new Image(
        'https://drive.google.com/file/d/1PmYJuLbcUmeS2QC6OWZfEQlKoJ2k0FZE/view?usp=sharing',
        'ksiazka'
      ),
      'Catherine Hapka'
    ),
  ];

  getProducts() {
    return [...this.products];
  }
}
