import { AngularSvgIconModule } from 'angular-svg-icon';
import { AngularSvgIconPreloaderModule } from 'angular-svg-icon-preloader';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AuthorizationModule } from './authorization';
import { BrowserModule } from '@angular/platform-browser';
import { CatalogModule } from './catalog';
import { CategoriesService } from './core';
import { HistoryModule } from './history';
import { HomeModule } from './home';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { SharedModule } from './shared/shared.module';
import { ShoppingCartModule } from './shopping-cart';
import { WildcardRoutingModule } from './wildcard-routing.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    ShoppingCartModule,
    CatalogModule,
    HistoryModule,
    HomeModule,
    AngularSvgIconModule.forRoot(),
    AngularSvgIconPreloaderModule.forRoot({
      configUrl: './assets/svgs.json',
    }),
    HttpClientModule,
    AuthorizationModule,
    WildcardRoutingModule,
  ],
  providers: [CategoriesService],
  bootstrap: [AppComponent],
})
export class AppModule {}
