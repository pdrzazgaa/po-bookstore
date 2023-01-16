import { Category } from '../models';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class CategoriesService {
  private http: HttpClient;
  private baseUrl: string = 'http://10.182.197.198:6060/categories';
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

  constructor(http: HttpClient) {
    this.http = http;
  }

  getCategories() {
    console.log('fetching...');
    this.fetchCategories().subscribe((response) => {
      console.log('response received');
      console.log(response);
    });
    if (!this.categories.length) {
      this.fetchCategories();
    }
    return [...this.categories];
  }

  private fetchCategories(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
}
