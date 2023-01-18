import { EventEmitter, Injectable } from '@angular/core';
import { Category } from '../models';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class CategoriesService {
  private http: HttpClient;
  private baseUrl: string = 'http://localhost:6060/categories';
  private categories: Category[] = [];
  categoriesChanged = new EventEmitter<Category[]>();
  constructor(http: HttpClient) {
    this.http = http;
  }

  getCategories() {
    if (!this.categories.length) {
      this.fetchCategories().subscribe(
        (response: { id: number; name: string; children: any[] }) => {
          let categories: Category[] = [];
          response.children.forEach((category) => {
            const subcategories: Category[] = [];
            category.children.forEach((category: any) => {
              subcategories.push(new Category(category.id, category.name, []));
            });
            categories.push(new Category(category.id, category.name, subcategories));
          });
          this.categories.push(new Category(response.id, response.name, categories));
          this.categoriesChanged.emit(this.categories);
        }
      );
    }
    return this.categories;
  }

  private fetchCategories(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
}
