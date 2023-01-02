import { RouterModule, Routes } from '@angular/router';
import { BookPageComponent } from './book-page';
import { BooksPageComponent } from './books-page';
import { NgModule } from '@angular/core';

const routes: Routes = [
  { path: 'book', component: BookPageComponent },
  { path: 'books', component: BooksPageComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CatalogRoutingModule {}
