import { CatalogRoutingModule } from './catalog-routing.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ProductPageComponent } from './product-page/product-page.component';
import { ProductsPageComponent } from './products-page/products-page.component';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [ProductPageComponent, ProductsPageComponent],
  imports: [CommonModule, CatalogRoutingModule, SharedModule],
  exports: [ProductPageComponent, ProductsPageComponent],
})
export class CatalogModule {}
