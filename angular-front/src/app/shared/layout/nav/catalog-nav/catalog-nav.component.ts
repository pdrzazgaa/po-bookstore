import { CategoriesService, Category } from 'src/app/core';
import { Component, Input, OnInit } from '@angular/core';
@Component({
  selector: 'app-catalog-nav',
  templateUrl: './catalog-nav.component.html',
  styleUrls: ['./catalog-nav.component.scss'],
})
export class CatalogNavComponent implements OnInit {
  @Input() title: string = '';
  private categoriesService: CategoriesService;
  categories: Category[] = [];

  constructor(categoriesService: CategoriesService) {
    this.categoriesService = categoriesService;
  }

  ngOnInit(): void {
    this.categories = this.categoriesService.getCategories();
  }
}
