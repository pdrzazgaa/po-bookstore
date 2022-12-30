import { BookPageComponent } from './book-page/book-page.component';
import { BooksPageComponent } from './books-page/books-page.component';
import { CatalogRoutingModule } from './catalog-routing.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';



@NgModule({
  declarations: [
    BookPageComponent,
    BooksPageComponent
  ],
  imports: [
    CommonModule,
    CatalogRoutingModule
  ]
})
export class CatalogModule { }
