import {
  FooterComponent,
  MessagePopupComponent,
  NavComponent,
  PageNotFoundComponent,
  ParcelMachineFormComponent,
} from './layout';
import { AngularSvgIconModule } from 'angular-svg-icon';
import { AngularSvgIconPreloaderModule } from 'angular-svg-icon-preloader';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

@NgModule({
  declarations: [
    FooterComponent,
    MessagePopupComponent,
    NavComponent,
    PageNotFoundComponent,
    ParcelMachineFormComponent,
  ],
  imports: [
    CommonModule,
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
  ],
})
export class SharedModule {}
