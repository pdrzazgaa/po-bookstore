import { CategoriesService, Category } from 'src/app/core';
import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-catalog-nav',
  templateUrl: './catalog-nav.component.html',
  styleUrls: ['./catalog-nav.component.scss'],
})
export class CatalogNavComponent implements OnInit, OnDestroy {
  @Input() title: string = '';
  private categoriesService: CategoriesService;
  private categoriesSub?: Subscription;
  categories: Category[] = [];

  constructor(categoriesService: CategoriesService) {
    this.categoriesService = categoriesService;
  }

  ngOnInit(): void {
    this.categories = this.categoriesService.getCategories();
    this.categoriesService.categoriesChanged.subscribe((categories: Category[]) => {
      this.categories = categories;
      this.categories.forEach((cat) => console.log(cat.subcategories));
    });
  }

  ngOnDestroy(): void {
    this.categoriesSub?.unsubscribe();
  }
}
