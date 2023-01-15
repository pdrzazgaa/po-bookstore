import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CatalogRoutingModule } from './catalog-routing.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ProductPageComponent } from './product-page/product-page.component';
import { ProductTileComponent } from './products-page/product-tile/product-tile.component';
import { ProductsPageComponent } from './products-page/products-page.component';
import { SharedModule } from '../shared/shared.module';
import { SideMenuComponent } from './products-page/side-menu/side-menu.component';

@NgModule({
  declarations: [
    ProductPageComponent,
    ProductsPageComponent,
    SideMenuComponent,
    ProductTileComponent,
  ],
  imports: [
    CommonModule,
    CatalogRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [ProductPageComponent, ProductsPageComponent],
})
export class CatalogModule {}
