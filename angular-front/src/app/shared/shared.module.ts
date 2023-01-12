import {
  CatalogNavComponent,
  FooterComponent,
  MessagePopupComponent,
  NavComponent,
  PageNotFoundComponent,
  ParcelMachineFormComponent,
  SearchBarComponent,
} from './layout';
import { FromUrlPipe, UrlPipe } from './pipes';
import { AngularSvgIconModule } from 'angular-svg-icon';
import { AngularSvgIconPreloaderModule } from 'angular-svg-icon-preloader';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CloseMessagePopupComponent } from './layout/close-message-popup/close-message-popup.component';

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
    FromUrlPipe,
    CloseMessagePopupComponent,
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
    FromUrlPipe,
  ],
})
export class SharedModule {}
