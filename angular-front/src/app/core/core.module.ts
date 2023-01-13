import {
  AuthorizationGuardService,
  AuthorizationService,
  CategoriesService,
  OrdersService,
  ParcelMachineService,
  ProductsService,
  ShoppingCartService,
  UserService,
} from './services';
import { NgModule, Optional, SkipSelf } from '@angular/core';

@NgModule({
  imports: [],
  providers: [
    AuthorizationService,
    AuthorizationGuardService,
    CategoriesService,
    ProductsService,
    UserService,
    OrdersService,
    ShoppingCartService,
    ParcelMachineService,
  ],
  declarations: [],
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() core: CoreModule) {
    if (core) {
      throw new Error('You should import core module only in the root module');
    }
  }
}
