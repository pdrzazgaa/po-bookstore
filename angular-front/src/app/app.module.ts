import { AngularSvgIconModule } from 'angular-svg-icon';
import { AngularSvgIconPreloaderModule } from 'angular-svg-icon-preloader';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AuthorizationModule } from './authorization';
import { BrowserModule } from '@angular/platform-browser';
import { CatalogModule } from './catalog';
import { HistoryModule } from './history';
import { HomePageComponent } from './home';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { SharedModule } from './shared/shared.module';
import { ShoppingCartModule } from './shopping-cart';
import { WildcardRoutingModule } from './wildcard-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    ShoppingCartModule,
    CatalogModule,
    HistoryModule,
    WildcardRoutingModule,
    AngularSvgIconModule.forRoot(),
    AngularSvgIconPreloaderModule.forRoot({
      configUrl: './assets/svgs.json',
    }),
    HttpClientModule,
    AuthorizationModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
