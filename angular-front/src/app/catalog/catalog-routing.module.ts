import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { ProductPageComponent } from './product-page/product-page.component';
import { ProductsPageComponent } from './products-page/products-page.component';

const routes: Routes = [
  { path: 'product/:productName', component: ProductPageComponent },
  { path: 'products/:category', component: ProductsPageComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CatalogRoutingModule {}