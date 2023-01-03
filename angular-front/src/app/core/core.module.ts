import {
  CategoriesService,
  ProductService,
  ProductsService,
  UserService,
} from './services';
import { NgModule, Optional, SkipSelf } from '@angular/core';

@NgModule({
  imports: [],
  providers: [CategoriesService, ProductService, ProductsService, UserService],
  declarations: [],
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() core: CoreModule) {
    if (core) {
      throw new Error('You should import core module only in the root module');
    }
  }
}