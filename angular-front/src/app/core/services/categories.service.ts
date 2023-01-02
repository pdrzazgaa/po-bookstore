import { Category } from '../models';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class CategoriesService {
  private categories: Category[] = [
    new Category('Poradniki i albumy', [
      'Motywacja',
      'Podróze',
      'Zdrowie',
      'Sport',
      'Psychologia',
    ]),
    new Category('Komiksy', ['Motywacja', 'Podróze', 'Zdrowie', 'Sport', 'Psychologia']),
    new Category('Literatura piękna', [
      'Miłość',
      'Wojna',
      'Poezja',
      'Romantyzm',
      'Psychologia',
    ]),
    new Category('Literatura obyczajowa', [
      'Depresja',
      'Kulinaria',
      'Zdrowie',
      'Góry',
      'Morze',
    ]),
    new Category('Literatura obcokrajowa', [
      'Literatura brytyjska',
      'Literatura francuska',
      'Literatura amerykańska',
      'Literatura włoska',
    ]),
  ];

  getCategories() {
    return [...this.categories];
  }
}
