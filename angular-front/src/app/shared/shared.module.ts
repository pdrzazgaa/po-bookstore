import {
  CatalogNavComponent,
  FooterComponent,
  MessagePopupComponent,
  NavComponent,
  PageNotFoundComponent,
  ParcelMachineFormComponent,
  SearchBarComponent,
} from './layout';
import { AngularSvgIconModule } from 'angular-svg-icon';
import { AngularSvgIconPreloaderModule } from 'angular-svg-icon-preloader';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UrlPipe } from './pipes';

@NgModule({
  declarations: [
    FooterComponent,
    MessagePopupComponent,
    NavComponent,
    PageNotFoundComponent,
    ParcelMachineFormComponent,
    CatalogNavComponent,
    SearchBarComponent,
    UrlPipe,
  ],
  imports: [
    CommonModule,
    RouterModule,
    AngularSvgIconModule.forRoot(),
    AngularSvgIconPreloaderModule.forRoot({
      configUrl: './assets/svgs.json',
    }),
    HttpClientModule,
  ],
  exports: [
    FooterComponent,
    MessagePopupComponent,
    NavComponent,
    PageNotFoundComponent,
    ParcelMachineFormComponent,
    UrlPipe,
  ],
})
export class SharedModule {}
