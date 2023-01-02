import { BookPageComponent } from './book-page';
import { BooksPageComponent } from './books-page';
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
  ],
  exports: [
    BookPageComponent,
    BooksPageComponent
  ]
})
export class CatalogModule { }
