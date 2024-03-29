import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { ProductPageComponent } from './product-page/product-page.component';
import { ProductsPageComponent } from './products-page/products-page.component';

const routes: Routes = [
  { path: 'product/:id', component: ProductPageComponent },
  { path: 'products', component: ProductsPageComponent, pathMatch: 'full' },
  {
    path: 'products/:idCat/:category',
    component: ProductsPageComponent,
    pathMatch: 'full',
  },
  {
    path: 'products/:category/:idCat/:subcategory',
    component: ProductsPageComponent,
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CatalogRoutingModule {}
